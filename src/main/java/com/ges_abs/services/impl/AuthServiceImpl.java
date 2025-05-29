@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Map<String, Object> login(String login, String password) {
       Optional<User> findByLoginAndPassword(String login, String password);

        Map<String, Object> response = new HashMap<>();
        if (userOpt.isPresent()) {
            response.put("success", true);
            response.put("user", userOpt.get());
        } else {
            response.put("success", false);
            response.put("message", "Identifiants incorrects");
        }

        return response;
    }
}

