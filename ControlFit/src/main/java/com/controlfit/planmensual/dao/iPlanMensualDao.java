package com.controlfit.planmensual.dao;

import com.controlfit.planmensual.domain.PlanMensual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iPlanMensualDao extends JpaRepository<PlanMensual, Long>{
    //La ventaja de crear esta interface, es que ya no tenemos que crear una
    //interface y luego implementarla
}
