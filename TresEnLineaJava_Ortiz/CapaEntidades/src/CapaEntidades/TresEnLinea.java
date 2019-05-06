
package CapaEntidades;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Mela
 */
public class TresEnLinea implements Serializable {
    
  
    private static int[][] matriz;
        private static TresEnLinea tresEnLinea;

        public TresEnLinea()
        {
            iniciaMatriz();
        }

        public int[][] getDatos()
        {
            return matriz; 
        }
        public boolean  asignaDatos(int x, int y, int jugador)
        {
            if (x >= 0 && x < 3 && y >= 0 && y < 3)
            {
                if (jugador == 1 && matriz[x][y] == -1)
                {
                    matriz[x][y] = 1;
                    return true;

                }
                if (jugador == 0 && matriz[x][y] == -1)
                {
                    matriz[x][y] = 0;
                    return true;
                }
            }
            return false ;
        }

        private static void iniciaMatriz()
        {
            if (matriz == null)
            {
                matriz = new int[3][];
                matriz[0] = new int[3];
                matriz[1] = new int[3];
                matriz[2] = new int[3];
            }
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    matriz[i][j] = -1;

        }



    
}
