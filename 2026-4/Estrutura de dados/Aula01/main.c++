#include<iostream>
#include<ctime>
#include<cstdlib>
#include<cmath>
#include<iomanip>

using namespace std;

int main() {
    
    int i, dim, maior = 0, menor = 1, aux, cont = 0, n; 
    float r;

    cout << "Informe a dimensao do vetor: ";
    cin >> dim;
    
    float v[dim];

    srand(time(NULL)); 
    
    // para não precisar colocar valor remotamente uso essa 
    // função juntamente ao ctime
    
    for(i = 0; i < dim; i++){
        
        n = rand() % 900; // faixa de 0 a 900 no cujo raiz prox 28.3
        r = sqrt(n); // calcula a raiz e atribui 
        
        if(r > 12.8 && r <= 28.3){
            v[i] = r;
            cont++;
        }
    }
    
    for(i = 0; i < 10; i++){
        cout << "v[" << i << "] = "
             << fixed << setprecision(2)
             << v[i] << endl;
    }

    cout << "\n\nNumeros gerados: " << cont;
    
    
//    for (i = 0; i < dim; i++) {

//        aux = rand() % 13;

//        if (aux >= 5) {
//            v[i] = aux;
//        }
//    }

    cout << endl;
    
    
//     for (i = 0; i < dim; i++) {
//       if (v[i] > maior){
//           maior = v[i];
//       }
       
//     }
    
//     for (i = 0; i < dim; i++) {
//       if (v[i] < menor){
//           menor = v[i];
//       }
//     }
    
//     for (i = 0; i < dim; i++) {
//         cout<<"v["<<i<<"] = " << v[i] << endl;
       
//     }
    
//     cout<< "Maior numero: " << maior<< endl;
//     cout<< "Menor numero: "<<menor<<endl;

}