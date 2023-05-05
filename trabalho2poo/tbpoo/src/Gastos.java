public class Gastos {

    private String[] nomedeGasto = new String[100];
    private String[] tipodeGasto= new String[100];
    private double[] valordeGasto= new double[100];
    private int[] pagamentodeGasto= new int[100];

    public Gastos(){}

    public String getNomeDeGasto(int i){
        return this.nomedeGasto[i];
    }



    public String getTipoDeGasto(int i){
        return this.tipodeGasto[i];
    }



    public double getValorDeGasto(int i){
        return this.valordeGasto[i];
    }



    public int getPagamentoDeGasto(int i){
        return this.pagamentodeGasto[i];
    }



    public void setNomeDeGasto(String nomedeGasto, int i){
        this.nomedeGasto[i] = nomedeGasto;
    }



    public void setTipoGasto(String tipodeGasto, int i){
        this.tipodeGasto[i] = tipodeGasto;
    }



    public void setValorGasto(double valordeGasto, int i){
        this.valordeGasto[i] = valordeGasto;
    }


    
    public void setPagamentoGasto(int pagamentodeGasto, int i){
        this.pagamentodeGasto[i] = pagamentodeGasto;
    }


}

