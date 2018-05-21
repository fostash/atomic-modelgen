package org.fostash.atomic.modelgen.processor;

import org.fostash.atomic.modelgen.annotation.DataStructure;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes({
        "org.fostash.atomic.modelgen.annotation.DataStructure"
})
public class DSLMetaModelGeneratorProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println(this.getClass().getSimpleName() + " is processing");
        roundEnv.getElementsAnnotatedWith(DataStructure.class).forEach(clazz -> {
            switch (clazz.getKind()) {
                case CLASS:
                    clazz.getEnclosedElements().forEach(field -> {
                        System.out.println(field.getAnnotationMirrors());
                        System.out.println(field.getModifiers());
                    });
            }
        });

        return true;
    }
}
