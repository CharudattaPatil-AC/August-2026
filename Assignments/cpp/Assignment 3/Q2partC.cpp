#include<iostream>
#include<memory>
using namespace std;
class AudioClip{
    private:
    string name;
    double duration;
    public:
    AudioClip(const string& name, double duration){
        this->name=name;
        this->duration=duration;
        cout<<"[AudioClip Loaded]";
    }
    ~AudioClip(){
        cout<<"[AudioClip deatroyed]";
    }
    string getName()const{
        return name;
    }

};
int main(){
    auto audio = make_shared<AudioClip>("explosion", 3.5);
    weak_ptr<AudioClip> observer = audio;
    if (auto clip = observer.lock())
        cout << "Clip alive: " << clip->getName() << endl;
    audio.reset();   
    if (observer.expired()) 
        cout << "Clip already unloaded." << endl;
}