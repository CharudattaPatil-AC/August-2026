```cpp
#include <iostream>
#include <vector>
#include <iomanip>
using namespace std;

class Vehicle
{
protected:
    string registration;
    string owner;
    double kmDriven;

public:
    Vehicle(string r, string o, double km)
    {
        registration = r;
        owner = o;
        kmDriven = km;
    }

    virtual double fuelCost(double tripKm) const = 0;

    virtual string getType() const
    {
        return "Vehicle";
    }

    string getRegistration() const
    {
        return registration;
    }

    string getOwner() const
    {
        return owner;
    }

    double getKmDriven() const
    {
        return kmDriven;
    }

    virtual ~Vehicle()
    {
        cout << "Vehicle Destructor: " << registration << endl;
    }
};

class Car : public Vehicle
{
private:
    double mileage;

public:
    Car(string r, string o, double km, double m = 15)
        : Vehicle(r, o, km)
    {
        mileage = m;
    }

    double fuelCost(double tripKm) const override
    {
        return (tripKm / mileage) * 100;
    }

    string getType() const override
    {
        return "Car";
    }

    ~Car()
    {
        cout << "Car Destructor: " << registration << endl;
    }
};

class Truck : public Vehicle
{
protected:
    double mileage;

public:
    Truck(string r, string o, double km, double m = 8)
        : Vehicle(r, o, km)
    {
        mileage = m;
    }

    double fuelCost(double tripKm) const override
    {
        return (tripKm / mileage) * 100;
    }

    string getType() const override
    {
        return "Truck";
    }

    ~Truck()
    {
        cout << "Truck Destructor: " << registration << endl;
    }
};

class ElectricTruck : public Truck
{
private:
    double battery;
    double costPerKm;

public:
    ElectricTruck(string r, string o, double km,
                  double b = 85, double cost = 1.9375)
        : Truck(r, o, km)
    {
        battery = b;
        costPerKm = cost;
    }

    double fuelCost(double tripKm) const override
    {
        return tripKm * costPerKm;
    }

    string getType() const override
    {
        return "Electric Truck";
    }

    double getBattery() const
    {
        return battery;
    }

    ~ElectricTruck()
    {
        cout << "ElectricTruck Destructor: "
             << registration << endl;
    }
};

void printFleetReport(const vector<Vehicle*>& fleet, double tripKm)
{
    cout << "\n===== FLEET REPORT =====\n";
    cout << "Trip Distance: " << tripKm << " km\n\n";

    cout << left
         << setw(12) << "Reg"
         << setw(18) << "Type"
         << setw(20) << "Owner"
         << "Km Driven" << endl;

    for (Vehicle* v : fleet)
    {
        cout << left
             << setw(12) << v->getRegistration()
             << setw(18) << v->getType()
             << setw(20) << v->getOwner()
             << v->getKmDriven() << endl;
    }

    cout << "\n===== FUEL / CHARGE COST =====\n";

    double minCost = 999999;
    Vehicle* efficient = nullptr;

    for (Vehicle* v : fleet)
    {
        double cost = v->fuelCost(tripKm);

        cout << v->getRegistration()
             << " (" << v->getType() << ") : Rs. "
             << fixed << setprecision(2)
             << cost;

        ElectricTruck* e = dynamic_cast<ElectricTruck*>(v);

        if (e != nullptr)
        {
            cout << " [Battery: "
                 << e->getBattery()
                 << "% charged]";
        }

        cout << endl;

        if (cost < minCost)
        {
            minCost = cost;
            efficient = v;
        }
    }

    cout << "\nMost Efficient Vehicle: "
         << efficient->getRegistration()
         << " (" << efficient->getType()
         << ") - Rs. "
         << fixed << setprecision(2)
         << minCost
         << " for " << tripKm << " km"
         << endl;
}

int main()
{
    vector<Vehicle*> fleet;

    fleet.push_back(new Car(
        "KA01AA001",
        "Ramesh Kumar",
        45200
    ));

    fleet.push_back(new Truck(
        "MH04BB002",
        "Shyam Logistics",
        123500
    ));

    fleet.push_back(new ElectricTruck(
        "GJ07CC003",
        "Green Fleet Co",
        89000,
        85
    ));

    fleet.push_back(new Car(
        "DL05DD004",
        "Amit Sharma",
        67500,
        18
    ));

    fleet.push_back(new Truck(
        "RJ14EE005",
        "Fast Transport",
        156000,
        10
    ));

    printFleetReport(fleet, 200);

    cout << "\n===== CLEANUP =====\n";

    for (Vehicle* v : fleet)
    {
        delete v;
    }

    fleet.clear();

    return 0;
}
```
