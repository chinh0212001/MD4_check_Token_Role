package rikkei.academy.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.academy.model.Category;
import rikkei.academy.model.User;
import rikkei.academy.repository.ICategoryRepository;
import rikkei.academy.security.userprincipal.UserDetailsServiceIMPL;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceIMPL implements ICategoryService{
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private UserDetailsServiceIMPL userDetailsServiceIMPL;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        User user = userDetailsServiceIMPL.getCurrentUser();
        category.setUser(user);
        categoryRepository.save(category);

    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);

    }
}
