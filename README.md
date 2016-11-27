Few considerations:

* you need java 8 to be installed on your machine
* you can check the code coverage by running: mvn cobertura:cobertura
* and you can find the results in "./target/site/cobertura/index.html"
* I assumed the interval should contain only positive values
* Even though it wasn't asked in the specification I assumed that checking things like
* the lower limit of the interval should be less or equal than the upper limit are necessary.
