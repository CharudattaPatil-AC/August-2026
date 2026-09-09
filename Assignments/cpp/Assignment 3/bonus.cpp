#include<iostream>
using namespace std;
class LogBuffer
{
private:
    int size;
    string* logs;
    mutable int accessCount = 0;

public:
    LogBuffer(int s)
    {
        size = s;
        logs = new string[size];
    }
    LogBuffer(const LogBuffer& other)
    {
        size = other.size;
        logs = new string[size];

        for (int i = 0; i < size; i++)
        {
            logs[i] = other.logs[i];
        }
    }
    void addLog(int index, string message)
    {
        if (index >= 0 && index < size)
        {
            logs[index] = message;
        }
    }
    void print() const
    {
        accessCount++;   // Allowed because accessCount is mutable

        cout << "Logs:" << endl;

        for (int i = 0; i < size; i++)
        {
            cout << logs[i] << endl;
        }
    }
    int getAccessCount() const
    {
        return accessCount;
    }
    ~LogBuffer()
    {
        delete[] logs;
    }
};

int main()
{
    LogBuffer log1(3);
    log1.addLog(0, "Application started");
    log1.addLog(1, "User logged in");
    log1.addLog(2, "Application closed");
    const LogBuffer readOnly(log1);
    readOnly.print();
    readOnly.print();
    readOnly.print();
    cout << "Times printed: "
         << readOnly.getAccessCount()
         << endl;
    return 0;
}