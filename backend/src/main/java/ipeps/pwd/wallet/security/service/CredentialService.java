package ipeps.pwd.wallet.security.service;

import ipeps.pwd.wallet.security.entity.Credential;

public interface CredentialService {

    Credential saveCredential(Credential credential);

    Credential findCredentialByUsername(String username);

}