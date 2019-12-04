package java.com.epam.secondtask.entity;

public class Client implements UberUsers {
    private int clientPosition;
    private int destinationPosition;

    public Client(int clientPosition, int destinationPosition) {
        this.clientPosition = clientPosition;
        this.destinationPosition = destinationPosition;
    }


    public int getClientPosition() {
        return clientPosition;
    }

    public int getDestinationPosition() {
        return destinationPosition;
    }


    public void setClientPosition(int clientPosition) {
        this.clientPosition = clientPosition;
    }

    public void setDestinationPosition(int destinationPosition) {
        this.destinationPosition = destinationPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        if (clientPosition != client.clientPosition) return false;
        return destinationPosition == client.destinationPosition;
    }

    @Override
    public int hashCode() {
        int result = clientPosition;
        result = 31 * result + destinationPosition;
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientPosition=" + clientPosition +
                ", destinationPosition=" + destinationPosition +
                '}';
    }
}
