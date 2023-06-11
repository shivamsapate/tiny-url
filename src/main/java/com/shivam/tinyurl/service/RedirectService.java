package com.shivam.tinyurl.service;

import com.shivam.tinyurl.entity.Redirect;
import com.shivam.tinyurl.exception.BadRequestException;
import com.shivam.tinyurl.exception.NotFoundException;
import com.shivam.tinyurl.reposistory.RedirectRepo;
import com.shivam.tinyurl.request.RedirectCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectService {
    @Autowired
    RedirectRepo redirectRepo;

    public RedirectService(RedirectRepo redirectRepo) {
        this.redirectRepo = redirectRepo;
    }

    public Optional<Redirect> createRedirect(RedirectCreationRequest request) {
        if(redirectRepo.existsByAlias(request.getAlias())) {
            throw new BadRequestException("Alias already exits");
        }
        System.out.println("Redirect request "+request.toString());
        Redirect redirect = redirectRepo.save(new Redirect(request.getAlias(), request.getUrl()));
        System.out.println("Redirect saved object "+redirect.toString());

        return Optional.ofNullable(redirect);
    }

    public Redirect getRedirect(String alias) {
        Redirect redirect = redirectRepo.findByAlias(alias).orElseThrow(() -> new NotFoundException("hey we don't have that alias! try making it"));
        return  redirect;
    }
}
