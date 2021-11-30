library(ggplot2)
library(dplyr)
library(ROCR)
library(caret)
library(DMwR)

dat <- read.csv("employee_attrition.csv")

data[data['EmployeeID'].duplicated()]

dat$gender_full <- as.numeric(dat$gender_full)
dat$job_title <- as.numeric(dat$job_title)
dat$city_name <- as.numeric(dat$city_name)
dat$department_name <- as.numeric(dat$department_name)
dat$BUSINESS_UNIT <- as.numeric(dat$BUSINESS_UNIT)

dat <- dat %>%
  mutate(status01 = ifelse(dat$STATUS == "ACTIVE", 1,0))%>%
  select(status01, everything(),-STATUS, -EmployeeID,-recorddate_key,-birthdate_key,
         -orighiredate_key, -terminationdate_key, -gender_short, -termreason_desc, -termtype_desc)

# Create new categories for job titles

# Look at full list of job titles and frequency
dat <- job_title.value_counts()

trace2 = go.Histogram(x=df.age)
data2 = go.Data([trace2])
layout2=go.Layout(title="Distribution of Age", xaxis={'title':'AGE'}, yaxis={'title':'Number of employees in data'})
figure2=go.Figure(data=data2,layout=layout2)
iplot(figure2)

hr_final=pd.concat([hr_active, hr_terminated]).reset_index()

hr_corr=hr_final.corr()
ggplot.figure(figsize=(13, 10))
sns.heatmap(hr_corr, annot = True, cmap = 'YlOrBr', fmt=".2f",
            vmin = -1, vmax = 1, linewidths = 0.1, linecolor = 'white', cbar = False)

hr_final=hr_final.drop(['termreason_desc', 'termtype_desc', 'index', 'orighiredate_key', 'terminationdate_key'], axis=1)

y=hr_final.STATUS
hr_final=hr_final.drop('STATUS', axis=1)

data[data['EmployeeID'].duplicated()]