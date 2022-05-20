package com.controlfit.planmensual.service;

import com.controlfit.planmensual.domain.PlanMensual;
import java.util.List;

public interface iPlanMensualService {
    public List<PlanMensual> listarPlanMensual();

    public void savePlan(PlanMensual planMensual);
    
    public void eliminar(PlanMensual planMensual);
    
    public PlanMensual encontrarPlanMensual(PlanMensual planMensual);
}
