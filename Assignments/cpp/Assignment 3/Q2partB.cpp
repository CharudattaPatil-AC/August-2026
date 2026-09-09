#include<iostream>
#include <memory>
using namespace std;
class Shader{
    private:
    string name;
    string type;
    public:
    Shader(const string &name,const string& type){
        this->name=name;
        this->type=type;
        cout<<"Shader Compiled";
    }
    ~Shader(){
        cout<<"Shader Destroyed";
    }
    int getReferenceCount(const shared_ptr<Shader>&ptr){
        return ptr.use_count();
    }
};
int main(){
    auto shader = make_shared<Shader>("main_vert", "vertex");
    cout << "Ref count: " << shader.use_count() << endl;   
    {
    auto rendererRef = shader;
    cout << "Ref count: " << shader.use_count() << endl;
    auto editorRef   = shader;
    cout << "Ref count: " << shader.use_count() << endl;    
    }
    cout << "Ref count: " << shader.use_count() << endl;   

}