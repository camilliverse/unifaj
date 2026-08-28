#include<iostream>
#include<cstdlib>
#include<ctime>
#include<iomanip>
using namespace std;

int main() {
    int lin, col, dim_lin, dim_col;

   cout<<"informe a dimensao linha da matriz ";
   cin>>dim_lin;

   cout<<"informe a dimensao coluna da matriz ";
   cin>>dim_col;

   int mat[dim_lin][dim_col];
   srand(time(NULL));

   //digitar numeros na matriz
   for(lin=0;lin<dim_lin;lin++){
        for(col=0;col<dim_col;col++){
            mat[lin][col] = rand() % 100;

        }
   }

   //mostra na tela a matriz
   cout<<"\n\n";
   for(lin=0;lin<dim_lin;lin++){
    for(col=0;col<dim_col;col++){
       cout<<setw(4)<<mat[lin][col]<<" ";
    }
    cout<<"\n\n";
   }
}