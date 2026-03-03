import json

class Filme:
    def __init__(self):
        self.titulo = ""
        self.ano = 0
        self.classificacao = ""
        self.nota = 0.0

    def from_json(self, json_data):
        self.titulo = json_data.get("titulo", "")
        self.ano = json_data.get("ano", 0)
        self.classificacao = json_data.get("classificacao", "N/A")
        self.nota = json_data.get("nota", 0.0)

    def __str__(self):
        return f"{self.titulo} ({self.ano}) - Classificação: {self.classificacao}, Nota: {self.nota}"

def main():
    caminho_arquivo = input("Digite o nome do arquivo JSON: ")

    try:
        with open(caminho_arquivo, 'r', encoding='utf-8') as f:
            filmes_json = json.load(f)
    except FileNotFoundError:
        print("Arquivo não encontrado.")
        return
    except json.JSONDecodeError:
        print("Erro ao decodificar o JSON.")
        return

    filmes = []
    for filme_json in filmes_json:
        filme = Filme()
        filme.from_json(filme_json)
        filmes.append(filme)

    filmes.sort(key=lambda f: f.nota, reverse=True)

    print("\nFilmes ordenados por nota:")
    for f in filmes:
        print(f)

if __name__ == "__main__":
    main()
