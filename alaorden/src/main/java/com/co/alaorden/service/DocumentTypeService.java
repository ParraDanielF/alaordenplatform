package com.co.alaorden.service;

import com.co.alaorden.model.DocumentTypeEntity;
import com.co.alaorden.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DocumentTypeService {
    @Autowired
    DocumentTypeRepository documentTypeRepository;

    public DocumentTypeEntity create (DocumentTypeEntity documentType){
        return documentTypeRepository.save(documentType);
    }

    public DocumentTypeEntity read (Integer id){
        return documentTypeRepository.findById(id).get();
    }

    public DocumentTypeEntity update (DocumentTypeEntity documentType , Integer id){
        DocumentTypeEntity tmpDocumentType = documentTypeRepository.findById(id).get();
        tmpDocumentType.setDescription(documentType.getDescription());
        return documentTypeRepository.save(tmpDocumentType);
    }

    public String delete (Integer id){
        documentTypeRepository.deleteById(id);
        return documentTypeRepository.findById(id).get() == null ?
                "Eliminado el tipo de doucmento "+ id.toString() :
                "No se elimino el tipo de doucmento " + id.toString() ;
    }
}
