public class Ganhos {

    private String[] nomedeGanho = new String[100];
    private String[] tipodeGanho = new String[100];
    private double[] valordeGanho = new double[100];

    public Ganhos(){}

    public String getNomedeGanho(int i){
        return this.nomedeGanho[i];
    }



    public String getTipodeGanho(int i){

        return this.tipodeGanho[i];
    }



    public double getValordeGanho(int i){

        return this.valordeGanho[i];
    }



    public void setNomeGanho(String nomedeGanho, int i){
        this.nomedeGanho[i] = nomedeGanho;
    }



    public void setTipoGanho(String tipodeGanho, int i){
        this.tipodeGanho[i] = tipodeGanho;
    }


    
    public void setValorGanho(double valordeGanho, int i){
        this.valordeGanho[i] = valordeGanho;
    }
}
