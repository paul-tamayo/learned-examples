package com.paultamayo.patterndesign.creational._03;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtilsBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Document {

    private AuthorInformation info;

    private String content;

    private String title;

    /**
     * Prototype permite realizar una clonación del objeto con los valores de la
     * instancia que lo generó
     */
    public Document clone() {
        return new Document(info.clone(), content, title);
    }

    /**
     * Necesario tener un constructor por defecto para poder realizar la clonación
     */
    public Document cloneWithBeanUtils()
            throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        return (Document) BeanUtilsBean.getInstance().cloneBean(this);
    }
}
