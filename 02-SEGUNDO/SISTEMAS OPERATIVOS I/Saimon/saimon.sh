SALIDA=0

NUM_COL_DEFAULT=4
ENTRE_T_DEFAULT=1
ESTADS_DEFAULT=log

EXTENSION_EST=".txt"

if test -f confi.cfg
    then SALIDA=0
else
    SALIDA=1
    echo "No se ha encontrado el archivo confi.cfg."
fi

if test $# -eq 1
    then if test $1 = "-g"
        then echo "Programa creado por:"
             echo "Daniel García González A3 70924776K"
             echo "Jorge Álvarez Cabdo A3 76581586G"
             SALIDA=1
    fi
elif test $# -ge 2
    then echo "Demasiados argumentos."
         echo "Ejecutar como saimon.sh o saimon.sh -g"
         SALIDA=1
fi

until test $SALIDA -eq 1
do
    clear
    echo "======================================"
    echo "||              SAIMON              ||"
    echo "======================================"
    echo "J) JUGAR"
    echo "C) CONFIGURACION"
    echo "E) ESTADISTICAS"
    echo "S) SALIR"

    echo "Saimon. Introduzca una opcion >>"

    read ELECCION
    clear

    case $ELECCION in
        j | J )   
            STARTTIME=$(date +%s)
            INCORRECTO=0

            i=0
            j=0

            CONTADOR=0
            VUELTAS=1

            VUELTAS_TOTALES=20










	    echo "================================="
	    echo "||           INICIO            ||"
	    echo "================================="

            NUM_COL=$(grep "NUMCOLORES=" < confi.cfg | cut -c 12)
            if [[ -z "$NUM_COL" ]];
                then NUM_COL=$NUM_COL_DEFAULT
                echo "No se ha encontrado el número de colores, se iniciará con: $NUM_COL"
            elif test $NUM_COL -lt 2 -o $NUM_COL -gt 4
                then NUM_COL=$NUM_COL_DEFAULT
                echo "El número de colores no es válido, se iniciará con: $NUM_COL"
            else   
                echo "Se ha encontrado el número de colores, se iniciará con: $NUM_COL"
            fi


            ENTRE_T=$(grep "ENTRETIEMPO=" < confi.cfg | cut -c 13)
            if [[ -z "$ENTRE_T" ]];
                then ENTRE_T=$ENTRE_T_DEFAULT
                echo "No se ha encontrado el tiempo entre colores, se iniciará con: $ENTRE_T"
            elif test $ENTRE_T -lt 1 -o $ENTRE_T -gt 4
                then ENTRE_T=$ENTRE_T_DEFAULT
                echo "El tiempo entre colores no es válido, se iniciará con: $NUM_COL"
            else   
                echo "Se ha encontrado el tiempo entre colores, se iniciará con: $ENTRE_T"
            fi



            ESTADS=$(grep "ESTADISTICAS=" < confi.cfg | cut -c 14-100)
            if [[ -z "$ESTADS" ]];
                then ESTADS=$ESTADS_DEFAULT
                echo "No se ha encontrado el nombre para el archivo de estadísticas se usará: $ESTADS"
            else   
                echo "Se ha encontrado el nombre para el archivo de estadísticas se usará: $ESTADS"

            fi
            if [[ $ESTADS =~ $EXTENSION_EST ]];
                then    sleep 0
                    else
                       ESTADS="$ESTADS.txt"
            fi

            if test -f $ESTADS
                then sleep 0
            else
                touch $ESTADS
		exec 7>>$ESTADS
		echo "Partida|Fecha|Hora|NumeroColores|Tiempo|LongitudSecuencia|SecuenciaColores" >&7
		exec 7>&-
            fi
           







            echo "VUELTA FINAL= VUELTA Nº$VUELTAS_TOTALES"


            echo ""
            echo "Pulse INTRO para empezar."
            read INTRO








   
            while test $CONTADOR -lt $VUELTAS -a $INCORRECTO -eq 0
            do
                clear
                echo "CONTADOR:"
                echo "$(( CONTADOR+1 ))"
                echo "VUELTA NÚMERO:"
                echo "$VUELTAS"





                for element in "${SECUENCIA[@]}"
                            do
                                clear
	   	    		echo "=================================="
	            		echo "            RONDA Nº$VUELTAS            "
	  	    		echo "=================================="
		    		echo ""
                                echo "Saimon dice: COLOR Nº$(( CONTADOR+1 ))"
                                if test "$element" = A
                                    then echo "AMARILLO"
                                elif test "$element" = R
                                    then echo "ROJO"
                                elif test "$element" = V
                                    then echo "VERDE"
                                elif test "$element" = Z
                                    then echo "AZUL"
                                fi

                                sleep $ENTRE_T
                                clear
                                (( CONTADOR= CONTADOR +1 ))           
                            done





                if test $CONTADOR -eq $(( VUELTAS -1 ))
                then    COLOR=$(( RANDOM % $NUM_COL + 1 ))
                    clear
	   	    echo "=================================="
	            echo "            RONDA Nº$VUELTAS            "
	  	    echo "=================================="
		    echo ""
                    echo "Saimon dice: COLOR Nº$(( CONTADOR+1 ))"
                    if test $COLOR -eq 1
                        then echo "AMARILLO"
                        SECUENCIA[$CONTADOR]=A
                    elif test $COLOR -eq 2
                        then echo "ROJO"
                        SECUENCIA[$CONTADOR]=R

                    elif test $COLOR -eq 3
                        then echo "VERDE"
                        SECUENCIA[$CONTADOR]=V
                    elif test $COLOR -eq 4
                        then echo "AZUL"
                        SECUENCIA[$CONTADOR]=Z
                    fi

                    sleep $ENTRE_T
                    clear
                fi





                if test $CONTADOR -le $VUELTAS
                    then ((CONTADOR= CONTADOR +1))
                fi




                if test $CONTADOR -eq $VUELTAS
                   then   
	   	    echo "=================================="
	            echo "            RONDA Nº$VUELTAS            "
	  	    echo "=================================="
		    echo ""
                    echo "Seleccione Amarillo (A), Rojo (R), Verde (V) o Azul (Z) con una INTRO entre cada uno."
                    echo ""

                   

                            echo "Saimon. Ahora tu !!! >>"
                             while test $i -lt $CONTADOR
                            do
                                read RESPUESTA
                                case $RESPUESTA in
                                    a | A )    SECUENCIA_INTRODUCIDA[$i]="A" ;;
                                    r | R )    SECUENCIA_INTRODUCIDA[$i]="R" ;;
                                    v | V )    SECUENCIA_INTRODUCIDA[$i]="V" ;;
                                    z | Z )    SECUENCIA_INTRODUCIDA[$i]="Z" ;;
                                esac
                                (( i=i+1 ))   
                            done



                             while test $j -lt $CONTADOR -a $INCORRECTO -eq 0
                            do
                                    if test "${SECUENCIA_INTRODUCIDA[$j]}" != "${SECUENCIA[$j]}"
                                     then    echo "INCORRECTO"
                                        INCORRECTO=1
                                fi
                                (( j=j+1 ))
                            done

                            if test $INCORRECTO -eq 0
                               then    echo ""
                                   echo "CORRECTO"
                            fi
                         read INTRO
                fi

                if test $CONTADOR -eq $VUELTAS -a $VUELTAS -lt $VUELTAS_TOTALES -a $INCORRECTO -eq 0
                    then ((VUELTAS= VUELTAS +1))
                         ((CONTADOR= 0))
                         (( i=0 ))
                         (( j=0 ))
                fi


            done

            if test $INCORRECTO -eq 0
               then echo "¡Enhorabuena! ¡Has ganado!"
            fi

            CONTADOR=0
            ENDTIME=$(date +%s)

            i=0
            j=0

            SECUENCIA_NUEVA=""

            for element in "${SECUENCIA[@]}"
                            do
                                if test "$element" = A
                                    then SECUENCIA_NUEVA="$SECUENCIA_NUEVA AMARILLO"
                                elif test "$element" = R
                                    then SECUENCIA_NUEVA="$SECUENCIA_NUEVA ROJO"
                                elif test "$element" = V
                                    then SECUENCIA_NUEVA="$SECUENCIA_NUEVA VERDE"
                                elif test "$element" = Z
                                    then SECUENCIA_NUEVA="$SECUENCIA_NUEVA AZUL"
                                fi
                                SECUENCIA_NUEVA="$SECUENCIA_NUEVA -"           
                            done

            exec 7>>$ESTADS
            echo "$BASHPID|$(date +%d/%m/%Y)|$(date +%H:%M:%S)|$NUM_COL|$(( $ENDTIME - $STARTTIME ))|$VUELTAS|$SECUENCIA_NUEVA" >&7
            exec 7>&-

            VUELTAS=1
            SECUENCIA=()
            SECUENCIA_INTRODUCIDA=()
            echo "Pulse INTRO para continuar."
            read INTRO
        ;;
        c | C )
	    clear
	    echo "================================="
	    echo "||       CONFIGURACIÓN         ||"
	    echo "================================="
            NUMCOLORES=0
            until test $NUMCOLORES -ge 2 -a $NUMCOLORES -le 4
            do
                echo "Introduzca el número de colores [entre 2 y 4]:"
                read NUMCOLORES
            done


            ENTRETIEMPO=0
            until test $ENTRETIEMPO -ge 1 -a $ENTRETIEMPO -le 4
            do
                echo "Introduzca el tiempo entre colores [entre 1 y 4]:"
                read ENTRETIEMPO
            done


            echo "Introduzca el nombre del fichero de estadísticas:"
            read ESTADISTICAS
            if [[ $ESTADISTICAS =~ $EXTENSION_EST ]];
            then    sleep 0
            else
                ESTADISTICAS="$ESTADISTICAS.txt"
            fi


            exec 7>confi.cfg
            echo "NUMCOLORES=$NUMCOLORES" >&7
            echo "ENTRETIEMPO=$ENTRETIEMPO" >&7
            echo "ESTADISTICAS=$ESTADISTICAS" >&7
            exec 7>&-
           


            echo "Pulse INTRO para continuar."
            read INTRO
        ;;
        e | E )

            ESTADS=$(grep "ESTADISTICAS=" < confi.cfg | cut -c 14-100)
            if [[ -z "$ESTADS" ]];
                then ESTADS=$ESTADS_DEFAULT   
            fi
            if [[ $ESTADS =~ $EXTENSION_EST ]];
                then    sleep 0
                    else
                       ESTADS="$ESTADS.txt"
            fi

	    clear
	    echo "================================="
	    echo "||        ESTADÍSTICAS         ||"
	    echo "================================="
	    echo ">>GENERAL"
            NUM_PARTIDAS=$(cat $ESTADS | wc -l)
	    NUM_PARTIDAS=$(( $NUM_PARTIDAS -1 ))
            echo "Número total de partidas jugadas: $NUM_PARTIDAS partida/s."
           

	    LOGITUD_TOTAL=$(cut -f 6 -d "|" < $ESTADS | awk '{total += $0} END{print total}')
	    echo "Media de las longitudes de las secuencias de todas las partidas jugadas: $((LOGITUD_TOTAL / NUM_PARTIDAS)) color/es."


	    TIEMPO_TOTAL=$(cut -f 5 -d "|" < $ESTADS | awk '{total += $0} END{print total}')
	    echo "Media de los tiempos de todas las partidas jugadas: $((TIEMPO_TOTAL / NUM_PARTIDAS)) segundo/s."


	    echo "Tiempo total invertido en todas las partidas: $TIEMPO_TOTAL segundo/s."

	    echo ""


	    echo ">>ESPECIALES"
	    TIEMPO_JUGADA_CORTA=$(cut -f 5 -d "|" < $ESTADS | sort -r | tail -1)
	    echo "Datos de la jugada/s más corta (Longitud: $TIEMPO_JUGADA_CORTA segundo/s):"
 	    awk -F"|" -v tiempo_jugada_corta="$TIEMPO_JUGADA_CORTA" '$5 == tiempo_jugada_corta' $ESTADS
	    echo ""
		

	    TIEMPO_JUGADA_LARGA=$(cut -f 5 -d "|" < $ESTADS | sort -n | tail -1)
	    echo "Datos de la jugada/s más larga (Longitud: $TIEMPO_JUGADA_LARGA segundo/s):"
 	    awk -F"|" -v tiempo_jugada_larga="$TIEMPO_JUGADA_LARGA" '$5 == tiempo_jugada_larga' $ESTADS
	    echo ""


	    LONGITUD_JUGADA_CORTA=$(cut -f 6 -d "|" < $ESTADS | sort -r | tail -1)
	    echo "Datos de la jugada/s de menor longitud  de colores (Longitud: $LONGITUD_JUGADA_CORTA color/es):"
 	    awk -F"|" -v longitud_jugada_corta="$LONGITUD_JUGADA_CORTA" '$6 == longitud_jugada_corta' $ESTADS
	    echo ""
		

	    LONGITUD_JUGADA_LARGA=$(cut -f 6 -d "|" < $ESTADS | sort -n | tail -1)
	    echo "Datos de la jugada/s de mayor longitud de colores (Longitud: $LONGITUD_JUGADA_LARGA color/es):"
 	    awk -F"|" -v longitud_jugada_larga="$LONGITUD_JUGADA_LARGA" '$6 == longitud_jugada_larga' $ESTADS
	    echo ""
	
	    echo "Porcentaje de los diferentes colores de la jugada de mayor longitud de colores:"
            echo "Compre el producto para desbloquear esta función!"
            echo ""

            echo ""
            echo "Pulse INTRO para continuar."
            read INTRO
        ;;
        s | S )
            SALIDA=1
        ;;
        * )
            echo "Opción no encontrada."
            echo ""
        ;;
    esac
done
