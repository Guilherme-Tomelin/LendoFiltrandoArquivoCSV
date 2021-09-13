
Programa IT Academy - Processo Seletivo

    O algoritmo apresenta um menu de opções:
        [1] - Consultar média de idade dos pacientes.
        [2] - Consultar internações por ano.
        [3] - Consultar hospitais.
        [4] - Calcular tempo de internação.
        [5] - Determinar tempo de espera na fila.
        [6] - Terminar o programa.

    Em seguida, o usuário entra com um valor do tipo INT para selecionar a opção desejada, 
    caso o usuário insira um valor inválido uma mensagem de erro aparecerá.

    O menu de opções foi construído com um Switch Case, quando uma opção válida é inserida
    o "Case" selecionado irá chamar um método.

    Os métodos foram criados em um pacote de utilidades, "utilities", lá foram criadas as classes "Menu" e "Utilities",
    nelas estão os métodos que são responsáveis pelas operações, cálculos, filtros e validações. 
    
    Caso o usuário escreva um valor inválido de entrada como "município residencial", "executante"  ou "solicitante", 
    o programa não retornará nada, os nomes devem ser escritos na entrada exatamente como estão no arquivo CSV.

    Também foi criada uma classe "User", no pacote "entities", nela contém seus atributos, métodos Get, Set e construtor.
    Cada "User" representa uma linha no arquivo CSV. 
    
    Na Classe principal, "Application", uma lista do tipo "User" é criada e nela está contido todos os dados do arquivo CSV.



    Autor: Guilherme Tomelin dos Santos - Estudande de Ciências da Computação PUCRS, 3° Semestre

