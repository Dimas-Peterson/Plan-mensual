package com.controlfit.planmensual.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "plan_mensual")
public class PlanMensual implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplan_mensual")
    private Long idplanmensual;

    @Column(name = "cupo_socios")
    private int cupoSocios;
    
    @Column(name = "notificacion_wpp")
    private boolean notificacionWpp;
    
    @Column(name = "app_movil_socios")
    private boolean appMovilSocio;
    
    @Column(name = "app_movil_duenios")
    private boolean appMovilDuenio;
    
    @Column(name = "compu_extra")
    private boolean compuExtra;
}
