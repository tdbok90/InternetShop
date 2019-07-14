 <!-- Custom styles for this template -->
<link href="https://getbootstrap.com/docs/4.3/examples/sign-in/signin.css" rel="stylesheet">
<!-- Begin page content -->
<main role="main" class="flex-shrink-0">
    <form class="form-signin" action="/login" method="post">
        <h1 class="h3 mb-3 font-weight-normal">Zaloguj się</h1>
        <label for="inputEmail" class="sr-only">Adres email</label>
        <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Hasło</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
    </form>
</main>