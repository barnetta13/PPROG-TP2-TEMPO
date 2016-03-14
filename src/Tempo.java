/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Martins
 */
public class Tempo {

    /**
     * @param args the command line arguments
     */
    
        private int hora;
        
        private int minuto;
        
        private int segundo;
        
        private static final int HORA_POR_OMISSAO = 0;
        
        private static final int MINUTO_POR_OMISSAO = 0;
        
        private static final int SEGUNDO_POR_OMISSAO = 0;
        
        public Tempo(int hora, int minuto, int segundo)
        {
            this.hora = hora;
            this.minuto = minuto;
            this.segundo = segundo;
        }
        
        public Tempo(int hora, int minuto)
        {
            this.hora = hora;
            this.minuto = minuto;
            this.segundo = SEGUNDO_POR_OMISSAO;
        }
        
        public Tempo(int hora)
        {
            this.hora = hora;
            this.minuto = MINUTO_POR_OMISSAO;
            this.segundo = SEGUNDO_POR_OMISSAO;
        }
        
        public Tempo()
        {
            this.hora = HORA_POR_OMISSAO;
            this.minuto = MINUTO_POR_OMISSAO;
            this.segundo = SEGUNDO_POR_OMISSAO;
        }
        
        public void setTempo(int hora, int minuto, int segundo) {
            this.hora = hora;
            this.minuto = minuto;
            this.segundo = segundo;        
    }
        
        public void setHora(int hora) {
            this.hora = hora;       
    }
        
        public void setMinuto(int minuto) {
            this.minuto = minuto;       
    }
        
        public void setSegundo(int segundo) {
            this.segundo = segundo;       
    }
        public int getHora() {
            return hora;       
    }
        
        public int getMinuto() {
            return minuto;       
    }
        
        public int getSegundo() {
            return segundo;       
    }
        
    public String toString() {
        return hora + ":" + minuto + ":" + segundo;
    }
    
    public String toStringAmOrPm(){
        if (hora<12)
        {
            return hora + ":" + minuto + ":" + segundo + " AM";
        }
        else
        {
            return hora-12 + ":" + minuto + ":" + segundo + " PM";
        }
    }
    public void acrescentaSegundo(){
        if (this.segundo <58)
        {
        this.segundo++;
        }
        else if (this.segundo == 59)
        {
            this.segundo=0;
            this.minuto++;
        }
        else if (this.segundo == 59 && this.minuto == 59)
        {
            this.segundo=0;
            this.minuto=0;
            this.hora++;
        }
        else if (this.segundo == 59 && this.minuto == 59 && this.hora == 23)
        {
            this.segundo=0;
            this.minuto=0;
            this.hora=0;
        }
    }
    
    public boolean comparaTempo(int hora,int minuto, int segundo)
    {
        boolean comparacao;
        Tempo tempo = new Tempo(hora,minuto,segundo);
        if (this.calculaSegundos(hora, minuto, segundo) > tempo.calculaSegundos(tempo.hora, tempo.minuto, tempo.segundo)) {
            System.out.println(this + " é maior que " + tempo);
            comparacao = true;
        }
        else 
        {
            System.out.println(this + " é menor que " + tempo);
            comparacao = false;
        }
        return comparacao;
    }
    public boolean comparaTempo(Tempo tempo)
    {
        boolean comparacao;
        if (comparaHora(tempo) == true)
        {
            comparacao = true;
            System.out.println(this + " é maior que " + tempo);
        }
        else 
        {
            comparacao = false;
            System.out.println(this + " é menor que " + tempo);
        }
        return comparacao;
    }
    
    public boolean comparaHora(Tempo tempo){
        boolean comparacao = false;
        if (this.hora > tempo.hora)
        {
            comparacao = true;
        }
        else if (this.hora < tempo.hora)
        {
            comparacao = false;
        }
        else if (comparaMinuto(tempo) == true)
        {
            comparacao = true;
        }
        else if (comparaMinuto(tempo) == false)
        {
            comparacao = false;
        }
        return comparacao;
    }
    
    public boolean comparaMinuto(Tempo tempo)
    {
        boolean comparacao = false;
        if (this.minuto > minuto)
        {
            comparacao = true;
        }
        else if (this.minuto < minuto)
        {
            comparacao = false;
        }
        else if (comparaSegundo(tempo) == true)
        {
            comparacao = true;
        }
        else if (comparaSegundo(tempo) == false)
        {
            comparacao = false;
        }
        return comparacao;
    }
    
    public boolean comparaSegundo(Tempo tempo)
    {
        boolean comparacao = false;
        if (this.segundo > tempo.segundo)
        {
            comparacao = true;
        }
        else if (this.segundo < tempo.segundo)
        {
            comparacao = false;
        }
        return comparacao;
    }
    
    public int calculaSegundos(int hora, int minuto, int segundo)
    {
        return hora * 3600 + minuto * 60 + segundo;
    }
    
    public int calculaSegundos(Tempo tempo)
    {
        return tempo.hora * 3600 + tempo.minuto * 60 + tempo.segundo;
    }
    
    public void diferencaSegundos (Tempo tempo)
    {
        int diferenca;
        diferenca = this.calculaSegundos(hora, minuto, segundo) - tempo.calculaSegundos(tempo);
        if (comparaTempo(tempo) == true)
        {
            
            System.out.println(" A diferença em segundos é de " + diferenca); 
        } 
    }
    
    public void diferencaSegundos (int hora, int minuto, int segundo)
    {
        int diferenca;
        diferenca = this.calculaSegundos(hora, minuto, segundo) - calculaSegundos(hora,minuto,segundo);
        System.out.println(" A diferença em segundos é de " + diferenca);
    }
    
    public void diferencaTempo (Tempo tempo)
    {
        int hora = Math.abs(this.getHora()-tempo.getHora());
        int minuto = Math.abs(this.getMinuto()-tempo.getMinuto());
        int segundo = Math.abs(this.getSegundo()-tempo.getSegundo());
        System.out.println("A diferença de tempos é de : " + hora + "H, "  + minuto + "M, " + segundo + "S.");
    }
    
    public void diferencaTempo (int hora, int minuto, int segundo)
    {
        int difHora = Math.abs(this.getHora()-hora);
        int difMinuto = Math.abs(this.getMinuto()-minuto);
        int difSegundo = Math.abs(this.getSegundo()-segundo);
        System.out.println("A diferença é de: " + difHora + "H, " + difMinuto + "M, " + difSegundo + "S.");
    }
    
}
