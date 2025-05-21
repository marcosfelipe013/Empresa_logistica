public class VehicleStorageAdapter implements IVehicleStorage {
    private OldVehicleStorage oldStorage;

    public VehicleStorageAdapter(OldVehicleStorage oldStorage) {
        this.oldStorage = oldStorage;
    }

    @Override
    public void saveVehicleData(Vehicle vehicle) {
        // Lógica de adaptação: converter o objeto Vehicle para o formato esperado pela biblioteca legada
        String data = String.format("%s,%s,%d", vehicle.getId(), vehicle.getModel(), vehicle.getYear());
        oldStorage.storeVehicleData(data);
    }
}