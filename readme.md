# ACK
So far when I want to get deep knowledge on `Dagger2` I have found lots of good tutorial.
But what I found from there is no one actually describe much about how to cope up with MVP pattern.
There are lots of good example on Github but I found myself confused when explore the code of individual Github projects.
The reason is each project has some different point of view regarding Dagger2.
So After exploring lot of projects I have finally managed to overcome my confusion and made my own way of implementing Dagger2.

# Base elements(annotation) of Dagger2

This [link1](https://android.jlelse.eu/dagger-2-part-i-basic-principles-graph-dependencies-scopes-3dfd032ccd82) and [link2](https://proandroiddev.com/dagger-2-part-ii-custom-scopes-component-dependencies-subcomponents-697c1fa1cfc) are the best example for understanding Dagger2 

Base elements (annotations) of Dagger 2

**@Inject** — base annotation whereby the “dependency is requested”

![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/Dag00.png)

**@Module** — classes which methods “provide dependencies”

**@Provide ** — methods inside @Module, which “tell Dagger how we want to build and present a dependency“

**@Component** — bridge between @Inject and @Module

![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/Dag0.png)

**@Scope** — enables to create global and local singletons
![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/Dag_5.PNG)

**@Qualifier** — if different objects of the same type are necessary
![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/Dag_6.PNG)



## Custom Scope annotation

Below you can see some features of the scope annotations:

- Usually the scope annotations are set for the Component and provide method.

- **If at least one provide method has a scope annotation the Component should have the same scope annotation.**

![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/Dag_3.PNG)

![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/Dag_4.PNG)

- The Component can be unscoped only if all provide methods in all its modules are unscoped too.


- All scope annotations for one component (for all modules with provide methods to be a part of Component and for the Component itself) should be the same.


## Component dependencies

Let’s denote Component dependencies traits right away:
   
- Two dependent components cannot have the same Scope. 


# How to inject Dependencies of a particular class (Common Practice)

- *Create an interface with base methods*

![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/Dag11.PNG)

- *Then Create a class that will be injected dependency and implement the interface. The constructor injection is 
applied here by `@Inject` annotation on constructor.*

![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/Dag12.PNG)


- *Now Create a Class with `@Module` annotation and create a method with `@Provides`*

![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/Dag13.PNG)

- *Now use `Method Injection` to get the object of the injected class.*

![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/Dag14.PNG)


## Diagram of how dependency injection work on this MVP architecture

![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/Diagram.jpg)

# Clean Architecture
This project has divided into 2 different layer
- presentation
- data

Currently we don't focus on *domain* layer.

## UML Diagram

### Data Layer

![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/UML1.PNG)

### Presentation Layer

![](https://github.com/anjandebnath/CleanArchitecture/blob/master/uml/UML_2.PNG)


*Thanks*

*Anjan Debnath*
