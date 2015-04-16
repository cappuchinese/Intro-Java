# Processing input from different sources #

## Learning outcomes ##
* processing command-line arguments
* being able to create and implement a simple OO design

## Assignment details ##
For this assignment, you will need to process some input from the command-line and, 
according to the info in the command-line you will need to instantiate the correct subclass to the supertype: Animal.
Also, you will need to override some methods to reflect the properties and habits of the subtype.

In this scenario, there is a superclass, Animal, that defines some basic ... animal behaviour. 
As you may well know, all animals are able to generate sound and are able to move.  
Of course, they tend to do this in vastly differing ways.

Another aspect that is quite universal for animals is that they tend to move slower when they are nearing seniority.  
The mathematical equation that has been determined (after years and years of expensive research)
 to approximate animal moving speed relative to the species' maximum speed is:  

```
speed = max_speed * (0.5 + (0.5 * ((max_age - age) / max_age)))
```

Of course, you will have to do some checking here: ages can never exceed the species maximum speed and age can never be negative.  

These are the animal species you will have to support in your application:


Species       | Maximum speed  | Maximum age  | Moving type
------------- | -------------- | ------------ | ------------
House mouse   | 21             | 13           | scurry
Horse         | 88             | 62           | gallop
Elephant      | 40             | 86           | thunder
Tortoise      | 0.3            | 190          | crawl

Given these animal species, implement the subclasses in the correct way, 
so that all objects behave correctly in this simulation system.

Here is some example usage

