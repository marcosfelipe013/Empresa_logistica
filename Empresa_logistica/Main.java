public class Main {
    public static void main(String[] args) {
        // Criando a biblioteca legada
        OldVehicleStorage oldStorage = new OldVehicleStorage();

        // Criando o adapter, passando a instância da biblioteca legada
        IVehicleStorage newStorageAdapter = new VehicleStorageAdapter(oldStorage);

        // Criando um objeto Vehicle
        Vehicle myVehicle = new Vehicle("ABC-123", "Sedan", 2023);

        // Utilizando a nova interface para armazenar dados através do adapter
        newStorageAdapter.saveVehicleData(myVehicle);
    }
}