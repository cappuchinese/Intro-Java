# Final assignment 4: Developing a Taxonomy Browser #

## Special challenge of this assignment: algorithm development ##

## Assignment details ##

Almost any chemical reaction is reversible, and will tend toward an equilibrium.  
For instance, with this simple reaction (where A = substrate and B = product):

`A ↔ B`  

an equilibrium will arise with a fixed ratio of A to B, regardless the starting amounts.
This fixed ratio is called the equilibrium constant, *Kc*.

For many reactions, equilibrium constants are known, and thus, when starting amounts are known, it is possible to calculate the equilibrium concentrations. You can find a nice example [here](http://chemwiki.ucdavis.edu/Core/Physical_Chemistry/Equilibria/Chemical_Equilibria/Calculating_an_Equilibrium_Concentration), or Google some yourself.

So far for a single isolated reaction.

Taking it up a notch, it is also possible to calculate equilibrium constants of coupled reactions. For instance, this is an example of a coupled reaction:

> `A + B ↔ C + D` Reaction 1
> > `C + E ↔ F + G` Reaction 2

When you combine A and B, products C and D will be produced and an equilibrium for reaction 1 will be reached. However, when E is also present, the second reaction will also take place, thereby lowering the concentration of C. The lower concentration of C will cause altered concentrations of A, B and C to restore the first equilibrium.  
After some time, an equilibrium will arise where all equilibrium constants are satisfied.

To calculate the final concentrations in the situation where the coupled reactions are both in equilibrium requires rather sophisticated calculus. Therefore a simplified approach is proposed for this assignment. The approach is one using iteration: simply take the first reaction, calculate equilibrium, and use this as input for the second reaction (and third...). Go back to the first reaction and re-calculate. After a certain number of iterations, equilibrium will have been reached, indicated by the fact that concentrations (hardly) change anymore.

It is your job to build an appropriate datamodel and functionality to be able to support the described use cases. Besides this, you will need to devise a simple file format that can hold reaction information. To keep things manageable, reactions can have at most two compounds on either side of the equation.

Now, create an executable that can be used in the ways outlined below.   

  1. ```java -jar EquilibriumFinder.jar --help```  
    shows informative help/usage information
  2. ```java -jar EquilibriumFinder.jar  --input <input file> --find_eq```  
   Using the input file, finds equilibrium using default settings.   
  3. ```java -jar EquilibriumFinder.jar  --input <input file> --find_eq <OPTIONS>```  
   As above, but with specified options for:  

    * --max_iter Maximum number of iterations (default = 100)  
    * --max_diff The maximum difference between any two reactions in two consecutive iterations before equilibrium is declared (default = 0.001)  
    * *ANY OTHER OPTION YOU THINK IS RELEVANT*

**For this assignment, no use cases are pre-defined. Work them out yourself and describe them well in your readme.md**  
