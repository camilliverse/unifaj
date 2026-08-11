#include<iostream>
#include<cstdlib>
#include<ctime>

using namespace std;
int main(){
    int mat[3][3];
    srand(time(NULL));
//preenche a matriz cpm numeros aleatorios
    for(int i =0; i<3;i++){
        for(int j=0;j<3;j++){
            mat[i][j] = rand()%10;
        }
    }
//mostra a matriz no formato de matriz
    for(int i=0;i<3;i++){
        for(int j=0; j<3;j++){

            cout<<mat[i][j]<<" ";
        }
        cout<<"\n\n";
    }
}