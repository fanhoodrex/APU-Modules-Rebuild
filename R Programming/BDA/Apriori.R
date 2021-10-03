install.packages("arules")
library(arules)
install.packages("arulesViz")
library (arulesViz)
library(RColorBrewer)

# in-build dataset
data("Groceries"); # data => to read inbuild datset
class(Groceries);
str(Groceries);

# Groceries = as(data.frame(lapply(Groceries, as.character), stringsAsFactors=T), "transactions")
inspect(head(Groceries, 2));

grocery_rules <- apriori(Groceries,
                         parameter = list(support = 0.03,
                                          confidence = 0.50))
grocery_rules

b <- inspect(head(sort(grocery_rules,by = "confidence"),2));
b

wholemilk_rules <- apriori(data=Groceries,
                           parameter = list (supp=0.02,conf = 0.5),
                           appearance = list (rhs="whole milk"));

c <- inspect(head(sort(wholemilk_rules, by = "confidence"), 2));
c

grocery_rules_increased_support <- apriori(Groceries,
                                           parameter = list(support = 0.03,
                                                            confidence = 0.1))
grocery_rules_increased_support

# solve the outcome for grocery_rules_increased_support
d <- inspect(head(sort(grocery_rules_increased_support, by = "confidence"), 2));

# This generates only one rule in the output.
subsets <- which(colSums(is.subset(grocery_rules, grocery_rules)) > 1);

grocery_rules <- grocery_rules[-subsets];

# This gives more than 1,500,000 rules
rules <- apriori(Groceries,
                 parameter = list(supp = 0.01,
                                  conf = 0.5))

# This gives 982,000 rules.
rules_chi2 <- apriori(Groceries,
                      parameter = list(supp = 0.01,
                                       conf = 0.5,
                                       arem = "chi2"))
rules <- apriori(Groceries,
                 parameter = list(supp = 0.01, 
                                  conf = 0.2))

inspect(rules[1:10])

arules::itemFrequencyPlot(Groceries, topN = 20, # Use the itemFrequencyPlot provided by arules package
                          col = brewer.pal(8, 'Paste12'),
                          main = 'Relative Item Frequency Plot',
                          type = "relative",
                          ylab = 'Item Frequency (Relative)')