#include <iostream>
#include <string>

using namespace std;

int main() {
    string mensagem, limpa = "", reversa = "";

    cout << "Digite a mensagem: ";
    getline(cin, mensagem);

    for (char c : mensagem) {
        if (c != ' ') {
            limpa += c;
        }
    }

    for (int i = limpa.length() - 1; i >= 0; i--) {
        reversa += limpa[i];
    }

    if (limpa == reversa) {
        cout << "É um palíndromo." << endl;
    } else {
        cout << "Não é um palíndromo." << endl;
    }

    return 0;
}