#include<iostream>
#include<string>
using namespace std;
class Vehicle{
    protected:
    string registrationNo;
    string ownerName;
    int yearOfManufacture;
    int kmDriven;
    
    
    public:
    Vehicle(const string&reg,const string& owner, int year, int km){
        registrationNo=reg;
        ownerName=owner;
        yearOfManufacture=year;
        kmDriven=km;
        cout<<"[Vehicle Constructor] "<<registrationNo<<" : "<<ownerName<<endl;
    }
    virtual ~Vehicle(){
        cout<<"Vehicle Destructor : "<<registrationNo<<endl;

    }

};

class Truck:public Vehicle{
    protected:
    double payloadCapacityTons;
    double fuelEfficiencyKmpl;
    public:
    Truck(const string& reg, const string& owner, int year, double km, double payload, double efficiency): Vehicle(reg,owner,year,km){
        payloadCapacityTons=payload;
        fuelEfficiencyKmpl=efficiency;
        cout<<"[Truck Constructor]"<<registrationNo<<endl;
    }
    ~Truck() override{
        cout<<"Truck Destructor "<<registrationNo<<endl;
    }
};
class ElectricTruck:public Truck{
    private:
    double batteryCapacityKwh;
    double rangePerChargeKm;
    public:
    ElectricTruck(const string& reg, const string& owner, int year, int km, double payload, double efficiency,double capacity, double range):Truck(reg,owner,year,km,payload,efficiency){
            batteryCapacityKwh=capacity;
            rangePerChargeKm=range;
            cout<<"[Electric Truck Constructor]"<<registrationNo<<endl;
    }
    ~ElectricTruck() override{
        cout<<"Electric Truck Destructor"<<registrationNo<<endl;
    }
};

int main(){
    {
    ElectricTruck et("V-ET001","Green Logistics",2026,5000,5,7,500,400);
    cout<<".....Scope Ends....."<<endl;
    }
    return 0;
}