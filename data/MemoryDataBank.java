/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import model.Programador;
import view.DialogProgramador;

/**
 *
 * @author crfranco
 */
public class MemoryDataBank implements IDao<Programador> {

    private List<Programador> memoryDataBank = new ArrayList<>();

    public List<Programador> getMemoryDataBank() {
        return memoryDataBank;
    }

    @Override
    public void save(Programador t) {
        this.memoryDataBank.add(t);
    }

    public void retorna() {
        for (int i = 0; i < getMemoryDataBank().size(); i++) {
            System.out.println(getMemoryDataBank().get(i));
        }
    }

      @Override
    public List<Programador> getOne(String name) {
        
        List<Programador> list = new ArrayList<Programador>();
         
			for(Programador p: memoryDataBank) {
                                if (p.getNome().toString().contains(name)){
                                    list.add(p);
                                };
			}
		return list;	
}

    @Override
    public List<Programador> list() {
        return memoryDataBank;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int posicao, Programador prog
    ) {
        memoryDataBank.add(posicao, prog);
    }

    @Override
    public void update(Programador novo
    ) {
        if (memoryDataBank.contains(novo)) {
            int posicao = memoryDataBank.indexOf(novo);

            delete(novo);
            update(posicao, novo);

        } else {
            this.save(novo);
        }
    }

    @Override
    public void delete(Programador p
    ) {
        memoryDataBank.remove(p);
    }

}
