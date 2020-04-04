## Code Structure

![Clef-Workflow-Single Direction Action](src/images/application-code-strcuture.png)


# Main Modules
* **Shared Module**
    * Development Shared:  
        * Shared Exceptions
        * Some functions like (Creator, Updater, Process and ....etc)
        * **Identity** definition (uuid, identityStatus and creation date)
    * Development Store:
        * [**Store**](modules/store-defintion.md) definition (**save**, **creator**, **updater** and **store-query**)
        * [**Store Query**](modules/store-query-defintion.md) main available query based on **Identity**, like `findByUuid`, `findAll`, `exist` and [more](/clef-workflow-api/quee-api-development/quee-api-development-store/src/main/kotlin/io/quee/api/develop/store/StoreQuery.kt).
        * [**Store Identity Creator**](modules/store-identity-creator-defintion.md) Based on structure, you need somewhere to create your identity like user, All business code use interface, so you don't need to define anonymous implementation for each identity, Only use `yourStoreInstance.identityCreator()` provided from store instance to create your identity based on your definition.    
        * [**Store Identity Updater**](modules/store-identity-updater-defintion.md) Like [**Store Identity Creator**](modules/store-identity-creator-defintion.md), but in updater case only you need to define the properties to be update, and you can use it from store instance 
        ```kotlin
        yourStoreInstance.run{ 
            yourIdentity.identityUpdater() 
        } 
        ```
    * Development UseCase
        * There is two type of usecase:
            * **[CommandUseCase](/clef-workflow-api/quee-api-development/quee-api-development-usecases/src/main/kotlin/io/quee/api/develop/usecase/type/CommandUseCase.kt):** Used to execute some commands based on your request definition, and don't give me back anything.   
            * **[FunctionalUseCase](/clef-workflow-api/quee-api-development/quee-api-development-usecases/src/main/kotlin/io/quee/api/develop/usecase/type/FunctionalUseCase.kt):** Used to process some business based on your request definition, and it will be back to you with response based on its definition.   
        
        
* TODO
