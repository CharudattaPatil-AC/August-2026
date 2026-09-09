#include<iostream>
#include<string>
using namespace std;
class Vehicle{
    protected:
    string registrationNo;
    string ownerName;
    int yearOfManufacture;
    double kmDriven;
    public:
    Vehicle(const string& reg, const string& owner,int year,double km){
        registrationNo=reg;
        ownerName=owner;
        yearOfManufacture=year;
        kmDriven=km;
    }
    virtual double fuelCost(double kmToTravel)const=0;
    virtual void describe()const{
        cout<<"Registration Number : "<<registrationNo<<endl;
        cout<<"Owner Name : "<<ownerName<<endl;
        cout<<"Year of Manufacturing : "<<yearOfManufacture<<endl;
        cout<<"Km Driven : "<<kmDriven<<endl;
    }
    virtual string vehicleType()const=0;
    virtual ~Vehicle(){
        
    }
    double getKmDriven()const{
        return kmDriven;
    }
    string getRegNo()const{
        return registrationNo;
    }

};

class Car: public Vehicle{
    private:
    string fuelType;
    double mileageKmpl;
    public:
    Car(const string &reg,const string owner,int year,double km,const string& fuel,double mileage):Vehicle(reg,owner,year,km){
            fuelType=fuel;
            mileageKmpl=mileage;
    }
    double fuelCost(double KmToTravel)const override{
        double fuelPrice;
        if(fuelType=="Petrol"){
            fuelPrice=106.00;
       }else if(fuelType=="Diesel"){
        fuelPrice=93.00;
       }else{
        cout<<"Invalid Fueltype"<<endl;
       }
       return (KmToTravel/mileageKmpl*fuelPrice);

    }
    string vehicleType()const override{
        return "Car";
    }
    void describe()const override{
        Vehicle::describe();
        cout<<"Fuel Type    : "<<fuelType<<endl;
        cout<<"Mileage      : "<<mileageKmpl<<"Km/L"<<endl;
    }
    ~Car() override{
        cout<<"Car Destructor"<<endl;
    }
    
};

class Truck : public Vehicle{
    protected:
    double payloadCapacityTons;
    double fuelEfficiencyKmpl;
    
    public:
    Truck(const string& reg, const string& owner, double efficiency,double payload,int year, int km):Vehicle(reg,owner,year,km){
        payloadCapacityTons=payload;
        fuelEfficiencyKmpl=efficiency;
    }
    double fuelCost(double KmToTravel) const override{
        double effectiveEfficiency=fuelEfficiencyKmpl*(1-(0.05*payloadCapacityTons));
        double fuelPrice=93.00;
        return (KmToTravel/effectiveEfficiency)*fuelPrice;

    }
    string vehicleType()const override{
        return "Truck";
    }
    void describe()const override{
        Vehicle::describe();
        cout<<"Payload Capacity     : "<<payloadCapacityTons<<endl;
        cout<<"Fuel Effeciency      : "<<fuelEfficiencyKmpl<<"Km/L"<<endl;
    }
    ~Truck() override{
        cout<<"Truck Destructor"<<endl;
    }


};

class ElectricTruck : public Truck{
    private:
    double batteryCapacityKWh;
    double rangePerChargeKm;
    
    public:
    ElectricTruck(const string& reg, const string& owner,int year, double km,double payload,double efficiency,double battery,double range):Truck(reg,owner,payload,efficiency,year,km){
            batteryCapacityKWh=battery;
            rangePerChargeKm=range;
    }
    double fuelCost(double KmToTravel) const override{
       double electricityCostPerUnit=9.50;
       return  (KmToTravel/rangePerChargeKm)*batteryCapacityKWh*electricityCostPerUnit;
    }
    string vehicleType()const override{
        return "Electric Truck";
    }
    void describe()const override{
        Vehicle::describe();
        cout<<"Payload Capacity       : "<<payloadCapacityTons<<endl;
        cout<<"Battery Capacity       : "<<batteryCapacityKWh<<"Kwh"<<endl;
        cout<<"Range per charge       : "<<rangePerChargeKm<<endl;
    }
    ~ElectricTruck() override{
        cout<<"Electric Truck Destructor"<<endl;
    }
};

class Van: public Vehicle{
    private:
    int seatingCapacity;
    double mileageKmpl;
    public:
    Van(const string &reg,const string& owner,int year,double km,int seats,double mileage):Vehicle(reg,owner,km,year){
            seatingCapacity=seats;
            mileageKmpl=mileage;
    }
    double fuelCost(double KmToTravel)const override{
        double fuelPrice=106.00;
        return (KmToTravel/mileageKmpl*fuelPrice);

    }
    string vehicleType()const override{
        return "Van";
    }
    void describe()const override{
        Vehicle::describe();
        cout<<"Seating Capacity    : "<<seatingCapacity<<endl;
        cout<<"Mileage             : "<<mileageKmpl<<"Km/L"<<endl;
    }
    ~Van() override{
        cout<<"Van Destructor"<<endl;
    }
    
};

int main(){
    Car car("MH12AB1234","Mohit",2026,25000,"Petrol",15);
    Truck truck("MH12AB1234","Mohit",4,8,2026,250000);
    ElectricTruck electricTruck("MH12ET9999","Suresh",2024,10000,3,7,500,400);
    Van van("MH12VN4444","Prakash",2021,35000,8,12);
    Vehicle* fleet[]={&car,&truck,&electricTruck,&van};
    int size=4;
    for (int i=0;i<size;i++){
        cout<<"\n===================================="<<endl;
        fleet[i]->describe();
        cout<<"Cost for 100 km : Rs. "<<fleet[i]->fuelCost(100)<<endl;
    }
    return 0;

}
