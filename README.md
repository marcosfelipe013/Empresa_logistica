# Implementação do Padrão de Projeto Adapter

Este projeto demonstra a implementação do padrão de projeto Adapter para integrar duas bibliotecas de armazenamento de dados de veículos incompatíveis: uma biblioteca legada (`OldVehicleStorage`) e uma nova interface (`IVehicleStorage`).

## Padrão Adapter

O padrão Adapter é um padrão de projeto estrutural que permite que interfaces de classes incompatíveis trabalhem juntas. Ele atua como um invólucro (wrapper) em torno de um objeto existente (o "adaptee"), adaptando sua interface para que ela corresponda à interface esperada (o "target").

Neste caso:
- **Target:** A interface `IVehicleStorage`, que define o método `saveVehicleData(Vehicle vehicle)`.
- **Adaptee:** A classe `OldVehicleStorage`, que possui o método `storeVehicleData(String data)`.
- **Adapter:** A classe `VehicleStorageAdapter`, que implementa a interface `IVehicleStorage` e utiliza uma instância de `OldVehicleStorage` para realizar o armazenamento.

## Implementação

1.  **Criação da Classe Adapter (`VehicleStorageAdapter`):**
    -   A classe `VehicleStorageAdapter` foi criada para implementar a interface `IVehicleStorage`.
    -   Ela possui um atributo privado do tipo `OldVehicleStorage` para manter uma referência à instância da biblioteca legada.
    -   O construtor da classe Adapter recebe uma instância de `OldVehicleStorage`.

2.  **Implementação da Lógica de Adaptação (`saveVehicleData`):**
    -   O método `saveVehicleData(Vehicle vehicle)` da interface `IVehicleStorage` foi implementado na classe `VehicleStorageAdapter`.
    -   Dentro deste método, a lógica de adaptação é realizada: o objeto `Vehicle` é convertido para uma string no formato esperado pelo método `storeVehicleData` da classe `OldVehicleStorage` (neste caso, os atributos `id`, `model` e `year` são concatenados separados por vírgulas).
    -   Em seguida, o método `storeVehicleData` da instância de `OldVehicleStorage` é chamado, passando a string formatada como argumento.

3.  **Demonstração da Integração (`Main`):**
    -   Na classe `Main`, uma instância de `OldVehicleStorage` e uma instância de `VehicleStorageAdapter` (passando a instância de `OldVehicleStorage`) são criadas.
    -   Um objeto `Vehicle` é instanciado.
    -   O método `saveVehicleData` da instância de `VehicleStorageAdapter` é chamado, demonstrando que a nova interface pode ser utilizada para interagir com a biblioteca legada através do Adapter.

## Desafios Encontrados e Soluções

Um dos principais desafios na implementação do padrão Adapter é garantir que todas as informações relevantes do objeto adaptee sejam corretamente mapeadas para o formato esperado pelo target. Neste caso, foi necessário definir um formato de string para representar os dados do veículo que fosse compatível com o método `storeVehicleData` da `OldVehicleStorage`.

Outro desafio potencial seria lidar com diferentes tipos de dados ou estruturas mais complexas. Em cenários mais elaborados, a lógica de adaptação dentro do Adapter poderia envolver transformações mais significativas dos dados.

A solução adotada foi uma conversão simples dos atributos do objeto `Vehicle` para uma string delimitada por vírgulas. Em um cenário real, poderia ser necessário utilizar um formato mais estruturado como JSON ou XML, e a lógica de adaptação no Adapter seria responsável por realizar a serialização e desserialização adequadas.

## Conclusão

A implementação do padrão Adapter demonstra como uma classe existente com uma interface incompatível pode ser utilizada em um sistema que espera uma interface diferente. Isso permite a reutilização de código legado e facilita a integração com novas bibliotecas e frameworks sem a necessidade de modificar o código existente.
