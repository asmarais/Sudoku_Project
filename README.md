# Suduko_Project

# Sudoku


---

## ⚙️ Instructions de compilation et d'exécution
### Côté Client
```bash

cd client

javac ICallback.java

javac Callback.java

rmic Callback

```
### Côté Serveur
```bash
cd Serveur

mv ../Client/ICallback.class .

mv ../Client/Callback_Stub.class .

javac *.java

rmic SudokuImpl FabSudokuImpl

java -Djava.security.policy=java.policy SudokuServer

java -Djava.rmi.server.codebase=http://localhost/Sudoku_www/Serveur/ -Djava.security.policy=java.policy SudokuServer
```

### Côté Client
```bash

cd Client

cp ../Serveur/SudokuImpl_Stub.class .

cp ../Serveur/SudokuInterface.class . 

cp ../Serveur/FabSudokuImpl_Stub.class .

cp ../Serveur/FabSudokuInterface.class .

javac *.java 

java -Djava.security.policy=java.policy SudokuClient

java -Djava.rmi.server.codebase=http://localhost/Sudoku_www/Client/ -Djava.security.policy=java.policy DynamicClient