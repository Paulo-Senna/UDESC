package negocio;

import java.util.*;
import dados.*;

public class Sistema {

    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Usuario usuarioLogado = null;

    public static String cadastrarUsuario(String nome, String senha) {
        Usuario u = new Usuario();
        u.setNome(nome);
        u.setSenha(senha);
        usuarios.add(u);
        return "Usuário cadastrado com sucesso.";
    }

    public static String fazerLogin(String nome, String senha) {
        Usuario u = buscarUsuarios(nome);
        if (u == null) {
            return "Usuário não encontrado.";
        }
        if (!u.getSenha().equals(senha)) {
            return "Senha incorreta.";
        }
        usuarioLogado = u;
        return "Login realizado com sucesso.";
    }

    public static String logout() {
        if (usuarioLogado == null) {
            return "Nenhum usuário está logado.";
        }
        String nome = usuarioLogado.getNome();
        usuarioLogado = null;
        return "Logout realizado de " + nome + ".";
    }

    public static boolean isUsuarioLogado() {
        return usuarioLogado != null;
    }

    public static String adicionarGasto(String nome, String data, String desc, double valor, TipoGasto tipo) {
        if (usuarioLogado == null) {
            return "É necessário fazer login para adicionar um gasto.";
        }

        Gastos g = new Gastos();
        g.setNome(nome);
        g.setData(data);
        g.setDesc(desc);
        g.setValor(valor);
        g.setTipo(tipo);

        usuarioLogado.adicionarGasto(g);
        return "Gasto adicionado com sucesso.";
    }

    public static List<Gastos> getGastosUsuarioLogado() {
        if (usuarioLogado == null) return new ArrayList<>();
        return usuarioLogado.getGastos();
    }

    public static Map<String, List<Gastos>> getGastosPorMes() {
        Map<String, List<Gastos>> gastosPorMes = new TreeMap<>();

        if (usuarioLogado == null) return gastosPorMes;

        for (Gastos g : usuarioLogado.getGastos()) {
            String data = g.getData();
            if (data.length() >= 7) {
                String mesAno = data.substring(3, 10);
                gastosPorMes.putIfAbsent(mesAno, new ArrayList<>());
                gastosPorMes.get(mesAno).add(g);
            }
        }

        return gastosPorMes;
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static boolean alterarGasto(String nomeGasto, int campo, String novoValor) {
        if (usuarioLogado == null) return false;

        for (Gastos g : usuarioLogado.getGastos()) {
            if (g.getNome().equalsIgnoreCase(nomeGasto)) {
                switch (campo) {
                    case 1: g.setNome(novoValor); return true;
                    case 2: g.setData(novoValor); return true;
                    case 3: g.setDesc(novoValor); return true;
                }
            }
        }
        return false;
    }

    public static boolean alterarValorGasto(String nomeGasto, double novoValor) {
        if (usuarioLogado == null) return false;

        for (Gastos g : usuarioLogado.getGastos()) {
            if (g.getNome().equalsIgnoreCase(nomeGasto)) {
                g.setValor(novoValor);
                return true;
            }
        }
        return false;
    }

    public static boolean apagarGasto(String nomeGasto) {
        if (usuarioLogado == null) return false;

        Iterator<Gastos> it = usuarioLogado.getGastos().iterator();
        while (it.hasNext()) {
            Gastos g = it.next();
            if (g.getNome().equalsIgnoreCase(nomeGasto)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    private static Usuario buscarUsuarios(String nome) {
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nome)) {
                return u;
            }
        }
        return null;
    }
}