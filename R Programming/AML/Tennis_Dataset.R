library(DataExplorer)
library(readr)
library(dplyr)
library(ggplot2)
library(tidyr)
library(sqldf)
library(stringr)
library(plotly)
library(viridis)
library(png)
library(grid)
library(plotrix)
library(caret)
library(tidyverse)

# Dataset importing 'Tennis_Dataset.csv'

# Data Exploration and Summary Generation
#create_report(atp)
print(summary(atp))
str(atp)
names(atp)

# Extract year from Date 
atp$year = str_sub(as.character(atp$Date), start= -4)

atp$year = as.numeric(atp$year)

# Identify if a match was an Upset
atp$upset = ifelse (as.numeric(atp$WRank) > as.numeric(atp$LRank), 0, 1)
atp$upset = as.factor(atp$upset)

# Court frequency
ggplot(atp, aes(x = fct_infreq(Court), fill = Court)) + 
  geom_bar()+ ylab("Count") + xlab("Court") 

# Court frequency w.r.t upset
atp_court = sqldf('select * from atp 
                       where Court in ("Indoor", "Outdoor")')
atp_court1 = sqldf('select Court, 
                     sum(upset) No_of_upsets from atp_court group by court ')
ggplot(atp_court1, aes(Court, No_of_upsets, fill = No_of_upsets, label=No_of_upsets)) +
  geom_bar(stat = "identity") + scale_color_viridis() + 
  geom_label(colour = "white", position= position_dodge(width=1)) + 
  labs(x= "Courts", y="No of Upsets", title = "No of Upsets by Courts")


# Surface frequency
ggplot(atp, aes(x = fct_infreq(Surface), fill = Surface)) + 
  geom_bar()+ ylab("Count") + xlab("Surface")

# Surface frequency w.r.t upset
atp_surface = sqldf('select * from atp 
                       where Surface in ("Hard", "Clay", "Grass", "Carpet")')
atp_surface1 = sqldf('select Surface, 
                   sum(upset) No_of_upsets from atp_surface group by surface ')
ggplot(atp_surface1, aes(Surface, No_of_upsets, fill = No_of_upsets, label=No_of_upsets)) +
  geom_bar(stat = "identity") + scale_color_viridis() + 
  geom_label(colour = "white", position= position_dodge(width=1)) + 
  labs(x= "Surfaces", y="No of Upsets", title = "No of Upsets by Surfaces")


# Match type Count
atp$upset <- factor(atp$upset, levels=c(0,1), labels=c("Normal", "Upset"))
atp_upset = sqldf('select upset
                 , count(*) match_count from atp group by upset')
ggplot(atp_upset, aes(upset, match_count, fill = match_count, label=match_count)) +
  geom_bar(stat = "identity") + scale_color_viridis() + 
  geom_label(colour = "white", position= position_dodge(width=1)) + 
  labs(x= "Match Type", y="Match Count", title = "No of Matches")

# Class distribution & sample count
mytable = table(atp$upset)
pct = round(mytable/sum(mytable)*100)
lbls = paste(c("Normal Match","\n\nUpset"), "\n", "     ", mytable,
             "\n", "        ", pct, "%", sep="")
pie(mytable, labels = lbls, col = rainbow(length(mytable)),
    main = "Class Distribution\n (with sample counts & percentage)")



# Filter our Grand Slam Matches
atp_grand_slam = sqldf('select * from atp 
                       where Tournament in ("Australian Open", "US Open" , "Wimbledon", "French Open")')
# Which Grand Slam sees more upsets
atp_gs_upset = sqldf('select Tournament, 
                     sum(upset) No_of_upsets from atp_grand_slam group by Tournament ')


# Number of upsets for each Grand Slam
ggplot(atp_gs_upset , aes(Tournament, No_of_upsets, fill = No_of_upsets, label=No_of_upsets)) +
  geom_bar(stat = "identity") + scale_color_viridis() + 
  geom_label(colour = "white", position= position_dodge(width=1)) + 
  labs(x= "Grand Slam Tournament", y="No of Upsets", title = "No of Upsets by Grand Slams")



# Number of upsets Vs. Years
uy = sqldf('select year, sum(upset) total_upsets from atp  group by year')
ggplot(uy, aes(year, total_upsets, group =1)) +geom_line(size =2, colour = "blue")+
  labs(x= "Year", y="No of Upsets", title = "No of Upsets by Year")



atp_wins = sqldf('select Winner Player, SUrface
                 , count(*) win_count from atp group by Winner,Surface')

atp_loss = sqldf('select Loser Player, SUrface
                 , count(*) loss_count from atp group by Loser,Surface')

atp_win_loss = merge(atp_wins,atp_loss,by=c("Player","Surface"))

atp_win_loss$pct = (atp_win_loss$win_count / 
                      (atp_win_loss$loss_count +atp_win_loss$win_count))*100

atp_win_loss[,'pct']=round(atp_win_loss[,'pct'],2)

atp_win_loss$Player = factor(atp_win_loss$Player
                             , levels = unique(atp_win_loss$Player)[order(-atp_win_loss$pct)])



# Win % on grass 
ggplot(atp_win_loss %>% filter(Surface == 'Grass' & (win_count+loss_count) >=75 & pct >70) %>% arrange(desc(pct)),
       aes(reorder(Player, -pct) , pct, fill = pct))+  scale_fill_gradient2(high='chartreuse4')+ geom_bar(stat = "identity")+ geom_text(aes(label=pct), color = "white", vjust = 5) +
  labs(x= "Players", y="Percentage Wins", title = "Percentage Wins in Grass Courts")


# Win % on clay 
ggplot(atp_win_loss %>% filter(Surface == 'Clay' & (win_count+loss_count) >=75 & pct >73) %>% arrange(desc(pct)),
       aes(reorder(Player, -pct) , pct, fill = pct))+ geom_bar(stat = "identity")+ scale_fill_gradient2(high='chocolate3') +geom_text(aes(label=pct), color = "white", vjust = 5) +
  labs(x= "Players", y="Percentage Wins", title = "Percentage Wins in Clay Courts")


# Win % on hard 
ggplot(atp_win_loss %>% filter(Surface == 'Hard' & (win_count+loss_count) >=75 & pct >76) %>% arrange(desc(pct)),
       aes(reorder(Player, -pct) , pct, fill = pct))+ geom_bar(stat = "identity")+ scale_fill_gradient2(high='mediumorchid4') +geom_text(aes(label=pct), color = "white", vjust = 5) +
  labs(x= "Players", y="Percentage Wins", title = "Percentage Wins in Hard Courts")




# ////////////////////////////////////////////////////////


atp$Best.of[atp$Best.of<3] <- 3

# Missing values to median
atp = atp %>% mutate(W1 = ifelse(is.na(W1),6,W1))
atp = atp %>% mutate(L1 = ifelse(is.na(L1),4,L1))
atp = atp %>% mutate(W2 = ifelse(is.na(W2),6,W2))
atp = atp %>% mutate(L2 = ifelse(is.na(L2),4,L2))
atp = atp %>% mutate(W3 = ifelse(is.na(W3),6,W3))
atp = atp %>% mutate(L3 = ifelse(is.na(L3),4,L3))
atp = atp %>% mutate(W4 = ifelse(is.na(W4),6,W4))
atp = atp %>% mutate(L4 = ifelse(is.na(L4),4,L4))
atp = atp %>% mutate(W5 = ifelse(is.na(W5),6,W5))
atp = atp %>% mutate(L5 = ifelse(is.na(L5),4,L5))

# Players ranks data type conversion 
atp$WRank=as.numeric(atp$WRank)
atp$LRank=as.numeric(atp$LRank)
atp$WRank[is.na(atp$WRank)]=1000
atp$LRank[is.na(atp$LRank)]=1000



# Series data type coversion
atp$Series=as.character(atp$Series)
atp$Series[atp$Series %in% c("ATP250","International",
                             "International Series")] = 250
atp$Series[atp$Series %in% c("ATP500","International Gold")] =500
atp$Series[atp$Series %in% c("Masters","Masters 1000")] =1000
atp$Series[atp$Series %in% c("Masters Cup")] =1500
atp$Series[atp$Series %in% c("Grand Slam")] =2000
atp$Series=as.numeric(atp$Series)


# court data type coversion
atp$Court=as.character(atp$Court)
atp$Court[atp$Court== "Indoor"] =1
atp$Court[atp$Court== "Outdoor"] =2
atp$Court=as.numeric(atp$Court)


# surface data type coversion
atp$Surface=as.character(atp$Surface)
atp$Surface[atp$Surface== "Carpet"] =1
atp$Surface[atp$Surface== "Clay"] =2
atp$Surface[atp$Surface== "Grass"] =3
atp$Surface[atp$Surface== "Hard"] =4
atp$Surface=as.numeric(atp$Surface)




# round data type coversion
atp$Round=as.character(atp$Round)
atp$Round[atp$Round %in% c("1st Round","0th Round","Round Robin")] =1
atp$Round[atp$Round== "2nd Round"] =2
atp$Round[atp$Round== "3rd Round"] =3
atp$Round[atp$Round== "4th Round"] =4
atp$Round[atp$Round== "Quarterfinals"] =5
atp$Round[atp$Round== "Semifinals"] =6
atp$Round[atp$Round== "The Final"] =7
atp$Round=as.numeric(atp$Round)


#add Tourney_index column, for tournement sorting. 
atp$Tourney_index=1
k=1
for (i in 2:nrow(atp))
{
  if (atp$Tournament[i]!=atp$Tournament[i-1])
  {
    k=k+1
  }
  atp$Tourney_index[i]=k
}


#sets percentage for the players in the match
atp$Wsets_r=atp$Wsets/(atp$Wsets+atp$Lsets)
atp$Lsets_r=1-atp$Wsets_r

#average game differential per set for the players in the match
atp$Wgame_diff=(atp$W1+atp$W2+atp$W3+atp$W4+atp$W5
                -atp$L1-atp$L2-atp$L3-atp$L4-atp$L5)
atp$Wgame_diff=atp$Wgame_diff/(atp$Wsets+atp$Lsets)
atp$Lgame_diff=atp$Wgame_diff*(-1)



# Class variable
for (i in 1:nrow(atp))
{
  if (atp$WRank[i] < atp$LRank[i])
  {
    atp$Class[i]=1
  }
  else
  {
    atp$Class[i]=0
  }
}




# remove betting and character variables
atp = select(atp, -c(X,Location,Tournament,Date,Winner,Loser,upset,WRank,LRank,CBW,CBL,GBW,GBL,IWW,IWL,SBW,SBL,B365W,B365L,B.WW,B.WL,EXW,EXL,PSW,PSL,WPts,LPts,UBW,UBL,LBW,LBL,SJW,SJL,MaxW,MaxL,AvgW,AvgL))



# delete rows with missing vlaues
atp = atp[complete.cases(atp), ]

library(magrittr)
atp[,-25] %<>% mutate_if(is.factor, as.numeric)

atp$Class = as.factor(atp$Class)

# ////////////////////////////////////////////////////////


# Imbalanced class problem


# Imbalanced class problem by ADASYN

library(MBA)
library(gstat)
library(sp)
library(automap)
library(randomForest)
library(UBL)

set.seed(1234)
atp1 = sample_n(atp, 20000)
table(atp1$Class)
mytable1 = table(atp1$Class)
pct1 = round(mytable1/sum(mytable1)*100)
lbls1 = paste(c("Normal Match\n","\n\n\nUpset\n"), mytable1,"\n",pct1,"%","\n", sep="")
pie(mytable1, labels = lbls1, col = rainbow(length(mytable1)),
    main = "Class Distribution\n (with sample counts & percentage)")

# checking the class distribution of this balanced dataset
atp_ADASYN = AdasynClassif(Class~.,atp1)
table(atp_ADASYN$Class)

mytable2 = table(atp_ADASYN$Class)
pct2 = round(mytable2/sum(mytable2)*100)
lbls2 = paste(c("Normal Match\n","\n\n\nUpset\n"), mytable2, "         ", "\n",
              pct2, "%", "          ","\n", sep="")
pie(mytable2, labels = lbls2, col = rainbow(length(mytable2)),
    main = "Class Distribution through ADASYN\n (with sample counts & percentage)")


# -------------


# Imbalanced class problem by SMOTE

library(lattice)
library(grid)
library(DMwR)

set.seed(1234)
atp2 = sample_n(atp, 20000)
table(atp2$Class)
mytable3 = table(atp2$Class)
pct3 = round(mytable3/sum(mytable3)*100)
lbls3 = paste(c("Normal Match","\n\nUpset"),"\n","   ",mytable3,"\n", 
              "     ",pct3,"%", sep="")
pie(mytable3, labels = lbls3, col = rainbow(length(mytable3)),
    main = "Class Distribution\n (with sample counts & percentage)")

# checking the class distribution of this balanced dataset
atp_SMOTE = SmoteClassif(Class ~ ., atp2, C.perc = "balance")
table(atp_SMOTE$Class)


mytable4 = table(atp_SMOTE$Class)
pct4 = round(mytable4/sum(mytable4)*100)
lbls4 = paste(c("Normal Match","\n\nUpset"), "\n", "              ", mytable4,
              "\n", "                 ", pct4, "%", sep="")
pie(mytable4, labels = lbls4, col = rainbow(length(mytable4)),
    main = "Class Distribution through SMOTE\n (with sample counts & percentage)")


# ////////////////////////////////////////////////////////


# FEATURE SELECTION



# Using FCBF

library(gtools)
library(Rcpp)
library(Biocomb)

method="InformationGain"
disc<-"MDL"
thr=0.1
thr.cons=0.05
attrs.nominal=numeric()
max.f=15
atp_ADASYN_FCBF = select.process(atp_ADASYN,method=method,disc.method=disc,threshold=thr, 
                    threshold.consis=thr.cons,attrs.nominal=attrs.nominal,max.no.features=max.f)
print(atp_ADASYN_FCBF)

x = print(sort(atp_ADASYN_FCBF))
names(atp_ADASYN[x])

atp_ADASYN_FCBF = select (atp_ADASYN ,-c(Court,Best.of,W4,L4,W5,L5,Wsets,year,
                                         Tourney_index))


atp_SMOTE_FCBF = select.process(atp_SMOTE,method=method,disc.method=disc, threshold=thr, 
                                threshold.consis=thr.cons,attrs.nominal=attrs.nominal,max.no.features=max.f)

print(atp_SMOTE_FCBF)

y = print(sort(atp_SMOTE_FCBF))
names(atp_SMOTE[y])

atp_SMOTE_FCBF = select (atp_SMOTE ,-c(L5,Wsets,Lsets,year,Tourney_index,Wsets_r,
                                       Lsets_r,Wgame_diff,Lgame_diff))