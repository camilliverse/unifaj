#include<iostream>
#include<cstdlib>
#include<ctime>
#include<iomanip>
using namespace std;

int main() {
    int lin, col;
    srand(time(NULL));
    

   cout<<"informe a dimensao linha da matriz: ";
   cin>>lin;

   cout<<"informe a dimensao coluna da matriz: ";
   cin>>col;

   int mat [lin][col];

   int par [lin * col];
   int impar [lin * col];

    

   for(int i=0; i<lin; i++) {
        for(int j=0; j<col; j++) {
             mat[i][j] = rand() % 30;
        }
   }

   int contador_par = 0, contador_impar = 0;

   for(int i=0; i<lin; i++) {
        for(int j=0; j<col; j++){
             //mat[i][j] % 2 == 0 ? par : impar;
             if(mat[i][j] % 2 == 0){
                par[contador_par] = mat[i][j];
                contador_par++;
             }else{
                impar[contador_impar] = mat[i][j];
                contador_impar++;
             }
        }
   }

    cout<<"\n\n";
    for(int i=0; i<lin; i++){
    for(int j=0; j<col; j++){
       cout<<setw(4)<<mat[i][j]<<" ";
    }
    cout<<"\n\n";
   }
    

}
