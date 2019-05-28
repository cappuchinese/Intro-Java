# Capstone project
## Implementing a bird browser

This is the capstone project of the course. You will work on an application that can be used to browse a "database" of all known bird species.


## Learning outcomes

* Creating a design
* Working with collections and sorting
* Algorithm development

## The assignment

In the `data` folder, you will find a txt file called `birds_observado_org.csv`. This file holds some information on all known bird species of the world. Here are the first few lines:

```
"id";"name";"Scientific name";"obscure";"rarity";"SPECIESGROUP";"SPECIESGROUP";"species type";"species type";"euring";"pons";"searchkey";"family";"AUTHOR";"list";"status";"refer_to";"plantlistid";"name order";
"693286";"";"Androrchis spec.";"0";"0";"1";"birds";"M";"multispecies";"0";"0";"";"";"";" unknown";"Native";"0";"";"";
"682516";"";"Coccycolius spec.";"0";"0";"1";"birds";"M";"multispecies";"0";"0";"";"";"";" unknown";"Native";"0";"";"";
"73939";"Swallow Flycatcher";"Hirundinea bellicosa";"0";"2";"1";"birds";"S";"species";"0";"0";"";"";"";" unknown";"Native";"0";"";"999";
"71881";"Flame rumped Sapphire";"Hylocharis pyropygia";"0";"2";"1";"birds";"S";"species";"0";"0";"";"";"";" unknown";"Native";"0";"";"989";
"71881";"Flame-rumped Sapphire";"Hylocharis pyropygia";"0";"2";"1";"birds";"S";"species";"0";"0";"";"";"";" unknown";"Native";"0";"";"999";
"75027";"San Cristobal Melidectes";"Melidectes sclateri";"0";"2";"1";"birds";"S";"species";"0";"0";"";"";"";" unknown";"Native";"0";"";"999";
"690370";"";"Melidectes spec.";"0";"0";"1";"birds";"M";"multispecies";"0";"0";"";"";"";" unknown";"Native";"0";"";"";
"680113";"";"Passerculus spec.";"0";"0";"1";"birds";"M";"multispecies";"0";"0";"";"";"";" unknown";"Native";"0";"";"";
```

There are three (mostly empty) classes provided: `Bird`, `BirdReader` and
`BirdCollection`. Class `Bird` has been implemented; you can use this as-is. Class `BirdReader` has only been implemented partially: the file reading part has been implemented. Of the last class, `BirdCollection`, only the **_public API_** has been defined.


