
package negocio;

import java.util.*;

import dados.*;
import persistencia.UsuarioDAO;
import persistencia.GastosDAO;

public class Sistema {

    //* tudo menos ultimos 3 metodos

    private static Usuario usuarioLogado = null;

    public static String cadastrarUsuario(String nome, String senha) {
        if (nome == null || nome.trim().isEmpty() || senha == null || senha.isEmpty()) {
            return "Nome e senha não podem ser vazios.";
        }

        UsuarioDAO dao = new UsuarioDAO();
        if (dao.buscarPorNome(nome) != null) {
            return "Este nome de usuário já existe.";
        }

        Usuario u = new Usuario();
        u.setNome(nome);
        u.setSenha(senha);
        dao.inserir(u);

        return "Usuário cadastrado com sucesso.";
    }

    public static String fazerLogin(String nome, String senha) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = dao.buscarPorNome(nome);

        if (u == null) return "Usuário não encontrado.";
        if (!u.getSenha().equals(senha)) return "Senha incorreta.";

        usuarioLogado = u;
        return "Login realizado com sucesso.";
    }

    public static String logout() {
        usuarioLogado = null;
        return "Logout realizado com sucesso.";
    }

    public static boolean isUsuarioLogado() {
        return usuarioLogado != null;
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static String adicionarGasto(String nome, String data, String desc, double valor, TipoGasto tipo) {
        if (usuarioLogado == null) return "É necessário fazer login.";

        Gastos g = new Gastos();
        g.setNome(nome);
        g.setData(data);
        g.setDesc(desc);
        g.setValor(valor);
        g.setTipo(tipo);

        GastosDAO dao = new GastosDAO();
       // System.out.println("ID do usuário logado: " + usuarioLogado.getId());
       //usei para verificar onde estava o problema dos gastos nao irem para o banco de dados

        dao.inserir(usuarioLogado.getId(), g);

        return "Gasto adicionado com sucesso.";
    }

    public static List<Gastos> getGastosUsuarioLogado() {
        if (usuarioLogado == null) return new ArrayList<>();

        GastosDAO dao = new GastosDAO();
        return dao.buscarPorUsuario(usuarioLogado.getId());
    }

    public static String alterarGasto(Gastos gastoParaAlterar, String novoNome, String novaData, String novaDesc, String novoValorStr, TipoGasto novoTipo) {
        if (gastoParaAlterar == null) return "Erro: Gasto não selecionado.";

        if (novoNome != null && !novoNome.trim().isEmpty()) gastoParaAlterar.setNome(novoNome);
        if (novaData != null && !novaData.trim().isEmpty()) gastoParaAlterar.setData(novaData);
        if (novaDesc != null && !novaDesc.trim().isEmpty()) gastoParaAlterar.setDesc(novaDesc);
        if (novoTipo != null) gastoParaAlterar.setTipo(novoTipo);
        if (novoValorStr != null && !novoValorStr.trim().isEmpty()){

            try {
                gastoParaAlterar.setValor(Double.parseDouble(novoValorStr.replace(",", ".")));
            } catch (NumberFormatException e) {
                return "Valor numérico inválido.";
            }
        }

        new GastosDAO().atualizar(gastoParaAlterar);
        return "Gasto alterado com sucesso.";
    }

    public static boolean apagarGasto(Gastos gastoParaRemover) {
        if (usuarioLogado == null || gastoParaRemover == null) return false;
        return new GastosDAO().remover(gastoParaRemover.getId());
    }

    public static List<Gastos> buscarGastosPorNome(String nome) {
        if (usuarioLogado == null) return new ArrayList<>();
        return new GastosDAO().buscarPorNome(usuarioLogado.getId(), nome);
    }

    public static Map<String, List<Gastos>> getGastosPorMes() {
        Map<String, List<Gastos>> gastosPorMes = new TreeMap<>();
        if (usuarioLogado == null) return gastosPorMes;

        for (Gastos g : getGastosUsuarioLogado()) {
            if (g.getData() != null && g.getData().length() >= 7) {
                String mesAno = g.getData().substring(3);
                gastosPorMes.putIfAbsent(mesAno, new ArrayList<>());
                gastosPorMes.get(mesAno).add(g);
            }
        }
        return gastosPorMes;
    }

    public static Map<TipoGasto, Double> getSomaGastosPorCategoria() {
        Map<TipoGasto, Double> somaPorCategoria = new EnumMap<>(TipoGasto.class);
        if (usuarioLogado == null) return somaPorCategoria;

        for (Gastos g : getGastosUsuarioLogado()) {
            somaPorCategoria.merge(g.getTipo(), g.getValor(), Double::sum);
        }
        return somaPorCategoria;
    }

    public static Map<String, Double> getSomaGastosPorMes() {
        Map<String, Double> somaPorMes = new TreeMap<>();
        if (usuarioLogado == null) return somaPorMes;

        Map<String, List<Gastos>> gastosPorMes = getGastosPorMes();
        for (String mes : gastosPorMes.keySet()) {
            double total = gastosPorMes.get(mes).stream().mapToDouble(Gastos::getValor).sum();
            somaPorMes.put(mes, total);
        }
        return somaPorMes;
    }
}
