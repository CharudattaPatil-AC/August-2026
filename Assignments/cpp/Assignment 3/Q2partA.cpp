#include<iostream>
#include <memory>
using namespace std;
class Texture{
    private:
    string name;
    int width;
    int height;
    public:
    Texture(const string &name,int width,int height){
        this ->name=name;
        this ->width=width;
        this -> height=height;
        cout<<"Texture Loaded"<<endl;
    }
    ~Texture(){
        cout<<"Texture Released "<<endl;
    }
    void display(const string& name, int width, int height){
        cout<<"Texture  :"<<name<<endl;
        cout<<"Dimensions :"<<width<<" * "<<height<<endl;
    }
};

int main(){

auto tex1 = make_unique<Texture>("player_sprite", 512, 512);
tex1->display("player_sprite",512,512);
// unique_ptr<Texture> tex2 = tex1;   // ← Comment this out, explain why it fails
unique_ptr<Texture> tex2 = move(tex1);
cout << "tex1 is null: " << (tex1 == nullptr ? "YES" : "NO") << endl;
return 0;
}