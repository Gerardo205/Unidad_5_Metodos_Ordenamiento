


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rip.Torres! ^-^
 */
public class Algoritmos {
    
//Jesús Ramón Lopez Ruiz
    public void burbuja(int [] array){
        int i,j,temporal=0;
        for(i=0; i<array.length; i++){
         for(j=i+1;j<array.length;j++){
            if(array[i]>array[j]){
               temporal=array[i];
               array[i]=array[j];
               array[j]=temporal;
            }
         }
      }
   }
    //Jaime Camil
    public void QuickSort(int[] array, int ini, int fin){
        int i, j, pivote, aux;
        i = ini;
        j = fin;
        pivote = array[(ini+fin)/2];
        do{
            while(array[i]<pivote) i++;
            while(array[j]>pivote) j--;
            
            //Realizamos el intercambio de datos del arreglo
            if(i<=j){
                aux=array[i];
                array[i]=array[j];
                array[j]=aux;
                i++; j--;
            }
        }while(i<=j);
        
        //RECURSIVIDAD
        if(ini<j) QuickSort(array, ini, j);                
        if(i<fin) QuickSort(array, i, fin);        
    }
    //Denílson Dominguez
    public void ShellSort(int[] array){
        int jump, i, j, k, aux;
        jump = array.length/2;
        while(jump>0){
            for(i=jump; i<array.length; i++){
                j = i-jump;
                while(j>=0){
                    k = j+jump;
                    if(array[j]<=array[k]){
                        j = -1;
                    } else {
                        aux = array[j];
                        array[j] = array[k];
                        array[k] = aux;
                        j-=jump;
                        
                    }
                }
            }
            jump = jump/2;
        }
    }
    //Cristian Gerardo Enciso Luna
    public int[] mezclaDirecta(int [] array){
        int i,j,k;
        if(array.length > 1){
            int nElementosIzq = array.length/2;
            int nElementosDer = array.length-nElementosIzq;
            int arregloIzq []= new int [nElementosIzq];
            int arregloDer  []= new int [nElementosDer];
            //Copiando los elemntos de parte primera a arreglo izq
            for(i=0; i<nElementosIzq; i++){
                arregloIzq[i] = array[i];
            }
            for(i=nElementosIzq ; i<nElementosIzq + nElementosDer ; i++){
                arregloDer[ i - nElementosIzq] = array[i];
            }
            //Recursividad
            arregloIzq = mezclaDirecta(arregloIzq);
            arregloDer = mezclaDirecta(arregloDer); 
            i=j=k=0;
            while(arregloIzq.length!=j && arregloDer.length!=k){
                if(arregloIzq[j] < arregloDer[k]){
                    array[i] = arregloIzq[j];
                    i++;j++;
                }else{
                    array[i] = arregloDer[k];
                    i++; k++;
                } 
            }
            //ArregloFinal
            while(arregloIzq.length!=j){
                array[i] = arregloIzq[j];
                i++;j++;
            }
            while(arregloDer.length!=k){
                array[i] = arregloDer[k];
                i++;k++;
            }
        }
        return array;
    }
    
    
    public void mezclaDirectaAyuda(int [] array){
        int i,j,k;
        if(array.length > 1){
            int nElementosIzq = array.length/2;
            int nElementosDer = array.length-nElementosIzq;
            int arregloIzq []= new int [nElementosIzq];
            int arregloDer  []= new int [nElementosDer];
            //Copiando los elemntos de parte primera a arreglo izq
            for(i=0; i<nElementosIzq; i++){
                arregloIzq[i] = array[i];
            }
            for(i=nElementosIzq ; i<nElementosIzq + nElementosDer ; i++){
                arregloDer[ i - nElementosIzq] = array[i];
            }
            //Recursividad
            arregloIzq = mezclaDirecta(arregloIzq);
            arregloDer = mezclaDirecta(arregloDer); 
            i=j=k=0;
            while(arregloIzq.length!=j && arregloDer.length!=k){
                if(arregloIzq[j] < arregloDer[k]){
                    array[i] = arregloIzq[j];
                    i++;j++;
                }else{
                    array[i] = arregloDer[k];
                    i++; k++;
                } 
            }
            //ArregloFinal
            while(arregloIzq.length!=j){
                array[i] = arregloIzq[j];
                i++;j++;
            }
            while(arregloDer.length!=k){
                array[i] = arregloDer[k];
                i++;k++;
            }
        }
    }
    //Cristian Gerardo Enciso Luna  
    public void mezclaNatural(int array[]){
        int izquierda=0, izq=0, derecha = array.length-1, der=derecha;
        boolean ordenado = false;
        do{
            ordenado = true;
            izquierda = 0;
            while(izquierda<derecha){
                izq=izquierda;
                while(izq<derecha && array[izq]<=array[izq+1]){
                    izq++;
                }
                der=izq+1;
                while(der==derecha-1 || der<derecha && array[der]<=array[der+1]){
                    der++;
                }
                if(der<=derecha){
                    mezclaDirectaAyuda(array);
                    ordenado=false;
                }
                izquierda=izq;
            }
        }while(!ordenado);
    }
    //Denílson Dominguez
    public void radix(int[] array){
    int x,i,j;
        for(x= Integer.SIZE-1; x>=0; x--){
            int[] auxiliar = new int[array.length];
            j=0;
            for(i= 0; i< array.length; i++){
                boolean mover= array[i]<< x>=0; 
                if(x==0 ? !mover:mover){
                    auxiliar[j]= array[i];
                    j++;
                }else{ 
                    array[i-j]= array[i];
                }
            }
            for(i=j; i<array.length; i++){
                array[i]= array[i-j];
            }
            array= auxiliar;
        }
    }
}
