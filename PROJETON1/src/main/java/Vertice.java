public class Vertice {

    int codigoDoLocal;
    String nomeDoLocal;
    String tipoDoLocal;

    public Vertice(int codigoDoLocal, String nomeDoLocal, String tipoDoLocal) {
        this.codigoDoLocal = codigoDoLocal;
        this.nomeDoLocal = nomeDoLocal;
        this.tipoDoLocal = tipoDoLocal;
    }

    public Vertice() {

    }

    public int getCodigoDoLocal() {
        return codigoDoLocal;
    }

    public String getNomeDoLocal() {
        return nomeDoLocal;
    }

    public String getTipoDoLocal() {
        return tipoDoLocal;
    }
}
