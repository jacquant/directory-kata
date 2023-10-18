package wtf.jacquant.directorykata.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wtf.jacquant.directorykata.controllers.json.company.*;
import wtf.jacquant.directorykata.domains.Company;
import wtf.jacquant.directorykata.mappers.CompanyMapper;
import wtf.jacquant.directorykata.services.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyMapper mapper;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyCreatedJson createCompany(@Valid @RequestBody final CompanyCreateJson companyCreateJson) {

        final Company company = companyService.createCompany(mapper.toDomainFromJson(companyCreateJson));
        return mapper.toCreatedJson(company);
    }

    @PutMapping("/{id}")
    public CompanyUpdatedJson updateCompany(@PathVariable final Long id, @Valid @RequestBody final CompanyUpdateJson companyUpdateJson) {
        if (companyUpdateJson.getId().equals(id)) {
            throw new IllegalArgumentException("Company id in path and body must be the same");
        }

        final Company company = companyService.updateCompany(mapper.toDomainFromJson(companyUpdateJson));
        return mapper.toUpdatedJson(company);
    }

    @GetMapping("/vat/{vatNumber}")
    public CompanyGetJson getByVatNumber(@PathVariable @Pattern(regexp = "^BE\\d{10}$") final String vatNumber) {
        final Company company = companyService.getCompanyByVatNumber(vatNumber);
        return mapper.toGetJson(company);
    }

    @GetMapping("")
    public List<CompanyGetJson> getAllCompanies() {
        final List<Company> companies = companyService.findAllCompanies();
        return mapper.toGetJson(companies);
    }
}
