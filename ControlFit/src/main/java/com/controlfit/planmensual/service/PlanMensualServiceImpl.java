
package com.controlfit.planmensual.service;

import com.controlfit.planmensual.dao.iPlanMensualDao;
import com.controlfit.planmensual.domain.PlanMensual;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlanMensualServiceImpl implements iPlanMensualService{
    
    @Autowired
    private iPlanMensualDao planMensualDao;
    
    @Override
    @Transactional(readOnly = true) //aclaramos que solo será una lectura, no habra modificacion
    public List<PlanMensual> listarPlanMensual() {
        return (List<PlanMensual>) planMensualDao.findAll();
        //se hace un cast porque el metodo debe retornar una lista
        //y findAll retorna UN objeto.
    }
    
    @Override
    @Transactional //En este caso no se aclara nada porque si se va a modificar info
    public void savePlan(PlanMensual planMensual) {
        planMensualDao.save(planMensual);
    }

    @Override
    public void eliminar(PlanMensual planMensual) {
    }

    @Override
    public PlanMensual encontrarPlanMensual(PlanMensual planMensual) {
        return planMensual;
    }
}
