
#include <iostream>
#include <vector>
#include <string>
#include <stdexcept>
#include <cctype>

using namespace std;

class DataProcessor
{
public:
    virtual void loadData(const string& source) = 0;
    virtual void processData() = 0;
    virtual void exportResult(const string& destination) = 0;
    virtual string processorType() const = 0;
    virtual int recordCount() const = 0;

    virtual void printSummary() const
    {
        cout << "Processor: " << processorType() << endl;
        cout << "Records: " << recordCount() << endl;
    }

    virtual ~DataProcessor()
    {
    }
};

class CSVProcessor : public DataProcessor
{
private:
    vector<string> records;

public:
    void loadData(const string& source) override
    {
        records.push_back("apple,red,100");
        records.push_back("banana,yellow,200");
        records.push_back("orange,orange,150");
        records.push_back("grapes,green,120");
        records.push_back("mango,yellow,180");
    }

    void processData() override
    {
        for (int i = 0; i < records.size(); i++)
        {
            for (int j = 0; j < records[i].length(); j++)
            {
                records[i][j] = toupper(records[i][j]);
            }
        }
    }

    void exportResult(const string& destination) override
    {
        cout << "[CSV EXPORT -> " << destination << "]" << endl;

        for (int i = 0; i < records.size(); i++)
        {
            cout << records[i] << endl;
        }
    }

    string processorType() const override
    {
        return "CSV Processor";
    }

    int recordCount() const override
    {
        return records.size();
    }
};

class SensorStreamProcessor : public DataProcessor
{
private:
    vector<double> readings;
    double mean;
    double minimum;
    double maximum;

public:
    void loadData(const string& source) override
    {
        readings.push_back(23.4);
        readings.push_back(21.8);
        readings.push_back(25.1);
        readings.push_back(24.6);
        readings.push_back(22.9);
        readings.push_back(26.3);
        readings.push_back(23.8);
        readings.push_back(24.2);
    }

    void processData() override
    {
        double sum = 0;

        minimum = readings[0];
        maximum = readings[0];

        for (int i = 0; i < readings.size(); i++)
        {
            sum += readings[i];

            if (readings[i] < minimum)
                minimum = readings[i];

            if (readings[i] > maximum)
                maximum = readings[i];
        }

        mean = sum / readings.size();
    }

    void exportResult(const string& destination) override
    {
        cout << "[SENSOR EXPORT -> " << destination << "]" << endl;
        cout << "Mean: " << mean << endl;
        cout << "Min: " << minimum << endl;
        cout << "Max: " << maximum << endl;
    }

    string processorType() const override
    {
        return "Sensor Stream Processor";
    }

    int recordCount() const override
    {
        return readings.size();
    }

    void printSummary() const override
    {
        cout << "Processor: " << processorType() << endl;
        cout << "Readings: " << recordCount() << endl;
        cout << "Mean: " << mean << endl;
        cout << "Min: " << minimum << endl;
        cout << "Max: " << maximum << endl;
    }
};

template <typename T>
class DataBuffer
{
private:
    T* data;
    int capacity;
    int head;
    int tail;
    int count;

public:
    DataBuffer(int c)
    {
        capacity = c;
        data = new T[capacity];
        head = 0;
        tail = 0;
        count = 0;
    }

    ~DataBuffer()
    {
        delete[] data;
    }

    void push(const T& value)
    {
        data[tail] = value;
        tail = (tail + 1) % capacity;

        if (count < capacity)
            count++;
        else
            head = (head + 1) % capacity;
    }

    T pop()
    {
        if (count == 0)
            throw underflow_error("Buffer is empty");

        T value = data[head];
        head = (head + 1) % capacity;
        count--;

        return value;
    }

    T peek() const
    {
        if (count == 0)
            throw underflow_error("Buffer is empty");

        return data[head];
    }

    bool isEmpty() const
    {
        return count == 0;
    }

    bool isFull() const
    {
        return count == capacity;
    }

    int size() const
    {
        return count;
    }

    template <typename U>
    friend ostream& operator<<(ostream& out, const DataBuffer<U>& buffer);
};

template <typename U>
ostream& operator<<(ostream& out, const DataBuffer<U>& buffer)
{
    out << "[";

    for (int i = 0; i < buffer.count; i++)
    {
        int index = (buffer.head + i) % buffer.capacity;
        out << buffer.data[index];

        if (i < buffer.count - 1)
            out << ", ";
    }

    out << "]";

    return out;
}

int main()
{
    vector<DataProcessor*> pipeline;

    pipeline.push_back(new CSVProcessor());
    pipeline.push_back(new SensorStreamProcessor());

    for (int i = 0; i < pipeline.size(); i++)
    {
        pipeline[i]->loadData("source_data");
        pipeline[i]->processData();
        pipeline[i]->printSummary();
        pipeline[i]->exportResult("output_dir");

        cout << "---" << endl;
    }

    // DataProcessor dp;
    // Error because DataProcessor is an abstract class.

    for (int i = 0; i < pipeline.size(); i++)
    {
        delete pipeline[i];
    }

    DataBuffer<int> tickBuffer(5);

    for (int i = 1; i <= 7; i++)
        tickBuffer.push(i * 10);

    cout << "Tick Buffer: " << tickBuffer << endl;

    DataBuffer<double> tempBuffer(4);

    tempBuffer.push(36.6);
    tempBuffer.push(37.1);
    tempBuffer.push(38.2);
    tempBuffer.push(36.9);

    cout << "Before pop: " << tempBuffer << endl;
    cout << "Popped: " << tempBuffer.pop() << endl;
    cout << "After pop: " << tempBuffer << endl;

    DataBuffer<string> logBuffer(3);

    logBuffer.push("INFO: Server started");
    logBuffer.push("WARN: High memory usage");
    logBuffer.push("ERROR: DB connection timeout");
    logBuffer.push("INFO: Retry successful");

    cout << "Log Buffer: " << logBuffer << endl;

    return 0;
}

