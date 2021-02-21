package by.omeganessy.shapetask.repository;

import by.omeganessy.shapetask.entity.Tetrahedron;
import by.omeganessy.shapetask.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Repository {
    public static final Logger logger = LogManager.getLogger();
    private List<Tetrahedron> tetrahedrons = new ArrayList<>();

    public boolean add(Tetrahedron tetrahedron) {
        logger.info( "New shape added: {}", tetrahedron);
        return tetrahedrons.add(tetrahedron);
    }

    public boolean addAll(Collection<? extends Tetrahedron> c) {
        logger.info( "new collection added to repository: {}", c);
        return tetrahedrons.addAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        logger.info("collection removed from repository: {}", c);
        return tetrahedrons.removeAll(c);
    }

    public List<Tetrahedron> getAll() {
        logger.info("got all repository ");
        return Collections.unmodifiableList(tetrahedrons);
    }

    public Optional<Tetrahedron> get(int index) {
        logger.info("index={} tetrahedrons size= {}",index, tetrahedrons.size());
        return Optional.of(tetrahedrons.get(index));
    }

    public Tetrahedron set(int index, Tetrahedron tetrahedron) {
        logger.info("new tetrahedron:{} added to repository place:{}",tetrahedron,index);
        return tetrahedrons.set(index, tetrahedron);
    }

    public List<Tetrahedron> query(Specification specification) {
        List<Tetrahedron> list = tetrahedrons.stream().filter(specification::specify).collect(Collectors.toList());
        logger.info("returned list {}", list);
        return list;
    }

    public void sortByParameter(Comparator<Tetrahedron> comparator) {
        tetrahedrons.sort(comparator);
    }
}
