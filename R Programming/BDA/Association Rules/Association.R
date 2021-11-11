install.packages("arules")
install.packages("arulesViz")

library (arules)
library (arulesViz)

data("AdultUCI");
class(AdultUCI);

AdultUCI = as(data.frame(lapply(AdultUCI, as.character), stringsAsFactors=T), "transactions")
class(AdultUCI);
      Adult = as(AdultUCI, "transactions");
rules = apriori(AdultUCI, parameter=list(support=0.02, confidence=0.5));
rules;
#inspect(head(sort(rules, by="lift"),3));
inspect(head(sort(rules),n=10))
plot(head(sort(rules,by="lift"),n=5),method = "graph",control = list(cex=0.92))
plot(rules);
plot(head(sort(rules,by="lift"),n=5),method = "grouped")

head(quality(rules));
plot(rules, shading="order", control=list(main ="Two-key plot"));

sel = plot(rules, measure=c("support","lift"), shading="confidence", interactive=TRUE);
subrules = rules[quality(rules)$confidence > 0.8];
subrules

plot(head(sort(rules,by="lift"),n=5),method = "grouped")
plot(rules, measure=c("support","lift"), shading="confidence");

plot(rules, shading="order", control=list(main ="Two-key plot"));